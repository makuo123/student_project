package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Advice;
import com.service.AdviceService;
import com.entity.Orders;
import com.entity.Users;
import com.entity.Doctor;
import com.service.OrdersService;
import com.service.UsersService;
import com.service.DoctorService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/advice", produces = "text/plain;charset=utf-8")
public class AdviceController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private AdviceService adviceService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private DoctorService doctorService;

	// 准备添加数据
	@RequestMapping("createAdvice.action")
	public String createAdvice(String id) {
		this.getRequest().setAttribute("id", id);
		return "admin/addadvice";
	}

	// 添加数据
	@RequestMapping("addAdvice.action")
	public String addAdvice(Advice advice) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String ordersid = this.getRequest().getParameter("id");
		Orders orders = this.ordersService.getOrdersById(ordersid);
		advice.setOrdersid(ordersid);
		advice.setUsersid(orders.getUsersid());
		advice.setDoctorid(adminid);
		advice.setAddtime(VeDate.getStringDateShort());
		this.adviceService.insertAdvice(advice);
		orders.setStatus("已就诊");
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getTodayOrders.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteAdvice.action")
	public String deleteAdvice(String id) {
		this.adviceService.deleteAdvice(id);
		return "redirect:/advice/getAllAdvice.action";
	}

	// 批量删除数据
	@RequestMapping("deleteAdviceByIds.action")
	public String deleteAdviceByIds() {
		String[] ids = this.getRequest().getParameterValues("adviceid");
		if (ids != null) {
			for (String adviceid : ids) {
				this.adviceService.deleteAdvice(adviceid);
			}
		}
		return "redirect:/advice/getAllAdvice.action";
	}

	// 更新数据
	@RequestMapping("updateAdvice.action")
	public String updateAdvice(Advice advice) {
		this.adviceService.updateAdvice(advice);
		return "redirect:/advice/getAllAdvice.action";
	}

	// 显示全部数据
	@RequestMapping("getAllAdvice.action")
	public String getAllAdvice(String number) {
		List<Advice> adviceList = this.adviceService.getAllAdvice();
		PageHelper.getPage(adviceList, "advice", null, null, 10, number, this.getRequest(), null);
		return "admin/listadvice";
	}

	@RequestMapping("getMyAdvice.action")
	public String getMyAdvice(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Advice advice = new Advice();
		advice.setDoctorid(adminid);
		List<Advice> adviceList = this.adviceService.getAdviceByCond(advice);
		PageHelper.getUserPage(adviceList, "advice", "getMyAdvice", 10, number, this.getRequest());
		return "admin/xlistadvice";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryAdviceByCond.action")
	public String queryAdviceByCond(String cond, String name, String number) {
		Advice advice = new Advice();
		if (cond != null) {
			if ("ordersid".equals(cond)) {
				advice.setOrdersid(name);
			}
			if ("usersid".equals(cond)) {
				advice.setUsersid(name);
			}
			if ("doctorid".equals(cond)) {
				advice.setDoctorid(name);
			}
			if ("contents".equals(cond)) {
				advice.setContents(name);
			}
			if ("addtime".equals(cond)) {
				advice.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.adviceService.getAdviceByLike(advice), "advice", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryadvice";
	}

	// 按主键查询数据
	@RequestMapping("getAdviceById.action")
	public String getAdviceById(String id) {
		Advice advice = this.adviceService.getAdviceById(id);
		this.getRequest().setAttribute("advice", advice);
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Doctor> doctorList = this.doctorService.getAllDoctor();
		this.getRequest().setAttribute("doctorList", doctorList);
		return "admin/editadvice";
	}

}
