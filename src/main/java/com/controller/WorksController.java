package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Dept;
import com.entity.Doctor;
import com.entity.Work;
import com.entity.Works;
import com.service.DeptService;
import com.service.DoctorService;
import com.service.WorksService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/works", produces = "text/plain;charset=utf-8")
public class WorksController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private WorksService worksService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private DoctorService doctorService;

	// 准备添加数据
	@RequestMapping("createWorks.action")
	public String createWorks() {
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Doctor> doctorList = this.doctorService.getAllDoctor();
		this.getRequest().setAttribute("doctorList", doctorList);
		this.getRequest().setAttribute("wno", "W" + VeDate.getStringDatex());
		return "admin/addworks";
	}

	// 添加数据
	@RequestMapping("addWorks.action")
	public String addWorks(Works works) {
		this.worksService.insertWorks(works);
		return "redirect:/works/createWorks.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteWorks.action")
	public String deleteWorks(String id) {
		this.worksService.deleteWorks(id);
		return "redirect:/works/getAllWorks.action";
	}

	// 批量删除数据
	@RequestMapping("deleteWorksByIds.action")
	public String deleteWorksByIds() {
		String[] ids = this.getRequest().getParameterValues("worksid");
		if (ids != null) {
			for (String worksid : ids) {
				this.worksService.deleteWorks(worksid);
			}
		}
		return "redirect:/works/getAllWorks.action";
	}

	// 更新数据
	@RequestMapping("updateWorks.action")
	public String updateWorks(Works works) {
		this.worksService.updateWorks(works);
		return "redirect:/works/getAllWorks.action";
	}

	// 显示全部数据
	@RequestMapping("getAllWorks.action")
	public String getAllWorks(String number) {
		List<Works> worksList = this.worksService.getAllWorks();
		PageHelper.getPage(worksList, "works", null, null, 10, number, this.getRequest(), null);
		return "admin/listworks";
	}

	@RequestMapping("getMyWorks.action")
	public String getMyWorks(String number) {
		String today = VeDate.getStringDateShort();
		String adminid = (String) this.getSession().getAttribute("adminid");
		List<Work> workList = new ArrayList<Work>();
		for (int i = 0; i < 14; i++) {
			String nxtDay = VeDate.getNextDay(today, "" + i);
			Works works = new Works();
			works.setDoctorid(adminid);
			works.setWorkdate(nxtDay);
			List<Works> worksList = this.worksService.getWorksByCond(works);
			Work work = new Work();
			work.setWorkdate(nxtDay);
			if (worksList.size() != 0) {
				Works x = worksList.get(0);
				work.setDoctorid(x.getDoctorid());
				work.setDoctorname(x.getDoctorname());
				work.setWno(x.getWno());
				work.setWorksid(x.getWorksid());
				work.setStatus("当班");
			} else {
				work.setStatus("不当班");
			}
			workList.add(work);
		}
		this.getRequest().setAttribute("today", today);
		this.getRequest().setAttribute("workList", workList);
		return "admin/xlistworks";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryWorksByCond.action")
	public String queryWorksByCond(String cond, String name, String number) {
		Works works = new Works();
		if (cond != null) {
			if ("wno".equals(cond)) {
				works.setWno(name);
			}
			if ("detpid".equals(cond)) {
				works.setDeptid(name);
			}
			if ("doctorid".equals(cond)) {
				works.setDoctorid(name);
			}
			if ("workdate".equals(cond)) {
				works.setWorkdate(name);
			}
			if ("memo".equals(cond)) {
				works.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.worksService.getWorksByLike(works), "works", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryworks";
	}

	// 按主键查询数据
	@RequestMapping("getWorksById.action")
	public String getWorksById(String id) {
		Works works = this.worksService.getWorksById(id);
		this.getRequest().setAttribute("works", works);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Doctor> doctorList = this.doctorService.getAllDoctor();
		this.getRequest().setAttribute("doctorList", doctorList);
		return "admin/editworks";
	}

}
