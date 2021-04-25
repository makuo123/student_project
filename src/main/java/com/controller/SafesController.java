package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Safes;
import com.service.SafesService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/safes", produces = "text/plain;charset=utf-8")
public class SafesController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private SafesService safesService;

	// 准备添加数据
	@RequestMapping("createSafes.action")
	public String createSafes() {
		return "admin/addsafes";
	}

	// 添加数据
	@RequestMapping("addSafes.action")
	public String addSafes(Safes safes) {
		safes.setAddtime(VeDate.getStringDateShort());
		this.safesService.insertSafes(safes);
		return "redirect:/safes/createSafes.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSafes.action")
	public String deleteSafes(String id) {
		this.safesService.deleteSafes(id);
		return "redirect:/safes/getAllSafes.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSafesByIds.action")
	public String deleteSafesByIds() {
		String[] ids = this.getRequest().getParameterValues("safesid");
		if (ids != null) {
			for (String safesid : ids) {
				this.safesService.deleteSafes(safesid);
			}
		}
		return "redirect:/safes/getAllSafes.action";
	}

	// 更新数据
	@RequestMapping("updateSafes.action")
	public String updateSafes(Safes safes) {
		this.safesService.updateSafes(safes);
		return "redirect:/safes/getAllSafes.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSafes.action")
	public String getAllSafes(String number) {
		List<Safes> safesList = this.safesService.getAllSafes();
		PageHelper.getPage(safesList, "safes", null, null, 10, number, this.getRequest(), null);
		return "admin/listsafes";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySafesByCond.action")
	public String querySafesByCond(String cond, String name, String number) {
		Safes safes = new Safes();
		if (cond != null) {
			if ("safesname".equals(cond)) {
				safes.setSafesname(name);
			}
			if ("addtime".equals(cond)) {
				safes.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.safesService.getSafesByLike(safes), "safes", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysafes";
	}

	// 按主键查询数据
	@RequestMapping("getSafesById.action")
	public String getSafesById(String id) {
		Safes safes = this.safesService.getSafesById(id);
		this.getRequest().setAttribute("safes", safes);
		return "admin/editsafes";
	}

}
