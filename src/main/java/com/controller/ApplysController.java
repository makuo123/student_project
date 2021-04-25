package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Applys;
import com.service.ApplysService;
import com.entity.Works;
import com.entity.Doctor;
import com.service.WorksService;
import com.service.DoctorService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/applys", produces = "text/plain;charset=utf-8")
public class ApplysController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ApplysService applysService;
	@Autowired
	private WorksService worksService;
	@Autowired
	private DoctorService doctorService;

	// 准备添加数据
	@RequestMapping("createApplys.action")
	public String createApplys(String id) {
		Works works = this.worksService.getWorksById(id);
		this.getRequest().setAttribute("works", works);
		this.getRequest().setAttribute("id", id);
		return "admin/addapplys";
	}

	// 添加数据
	@RequestMapping("addApplys.action")
	public String addApplys(Applys applys) {
		applys.setStatus("待审核");
		this.applysService.insertApplys(applys);
		return "redirect:/applys/getMyApplys.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteApplys.action")
	public String deleteApplys(String id) {
		this.applysService.deleteApplys(id);
		return "redirect:/applys/getAllApplys.action";
	}

	// 批量删除数据
	@RequestMapping("deleteApplysByIds.action")
	public String deleteApplysByIds() {
		String[] ids = this.getRequest().getParameterValues("applysid");
		if (ids != null) {
			for (String applysid : ids) {
				this.applysService.deleteApplys(applysid);
			}
		}
		return "redirect:/applys/getAllApplys.action";
	}

	// 更新数据
	@RequestMapping("updateApplys.action")
	public String updateApplys(Applys applys) {
		this.applysService.updateApplys(applys);
		return "redirect:/applys/getAllApplys.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "通过审核";
		Applys applys = this.applysService.getApplysById(id);
		applys.setStatus(status);
		this.applysService.updateApplys(applys);
		Works works = this.worksService.getWorksById(applys.getWorksid());
		works.setWorkdate(applys.getOrderdate());
		this.worksService.updateWorks(works);
		return "redirect:/applys/getAllApplys.action";
	}

	@RequestMapping("refuse.action")
	public String refuse(String id) {
		String status = "拒绝";
		Applys applys = this.applysService.getApplysById(id);
		applys.setStatus(status);
		this.applysService.updateApplys(applys);
		return "redirect:/applys/getAllApplys.action";
	}

	// 显示全部数据
	@RequestMapping("getAllApplys.action")
	public String getAllApplys(String number) {
		List<Applys> applysList = this.applysService.getAllApplys();
		PageHelper.getPage(applysList, "applys", null, null, 10, number, this.getRequest(), null);
		return "admin/listapplys";
	}

	@RequestMapping("getMyApplys.action")
	public String getMyApplys(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Applys applys = new Applys();
		applys.setDoctorid(adminid);
		List<Applys> applysList = this.applysService.getApplysByCond(applys);
		PageHelper.getUserPage(applysList, "applys", "getMyApplys", 10, number, this.getRequest());
		return "admin/xlistapplys";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryApplysByCond.action")
	public String queryApplysByCond(String cond, String name, String number) {
		Applys applys = new Applys();
		if (cond != null) {
			if ("worksid".equals(cond)) {
				applys.setWorksid(name);
			}
			if ("doctorid".equals(cond)) {
				applys.setDoctorid(name);
			}
			if ("reason".equals(cond)) {
				applys.setReason(name);
			}
			if ("workdate".equals(cond)) {
				applys.setWorkdate(name);
			}
			if ("orderdate".equals(cond)) {
				applys.setOrderdate(name);
			}
			if ("status".equals(cond)) {
				applys.setStatus(name);
			}
			if ("memo".equals(cond)) {
				applys.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.applysService.getApplysByLike(applys), "applys", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryapplys";
	}

	// 按主键查询数据
	@RequestMapping("getApplysById.action")
	public String getApplysById(String id) {
		Applys applys = this.applysService.getApplysById(id);
		this.getRequest().setAttribute("applys", applys);
		List<Works> worksList = this.worksService.getAllWorks();
		this.getRequest().setAttribute("worksList", worksList);
		List<Doctor> doctorList = this.doctorService.getAllDoctor();
		this.getRequest().setAttribute("doctorList", doctorList);
		return "admin/editapplys";
	}

}
