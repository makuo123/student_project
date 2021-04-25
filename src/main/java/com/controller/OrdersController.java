package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Orders;
import com.service.OrdersService;
import com.entity.Users;
import com.entity.Dept;
import com.entity.Cate;
import com.service.UsersService;
import com.service.DeptService;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/orders", produces = "text/plain;charset=utf-8")
public class OrdersController extends BaseController {
    // @Autowired的作用是自动注入依赖的ServiceBean
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private CateService cateService;

    @RequestMapping("monthtotal.action")
    public String monthtotal() {
        String firstDay = VeDate.getStringMonth() + "-01";
        String enday = VeDate.getEndDateOfMonth(VeDate.getStringDateShort());
        long days = VeDate.getDays(enday, firstDay) + 1;
        double money = 0;
        double allnum = 0;
        String html = "";
        for (int i = 0; i < days; i++) {
            String nxtDay = VeDate.getNextDay(firstDay, "" + i);
            Orders orders = new Orders();
            orders.setOrderdate(nxtDay);
            List<Orders> list = this.ordersService.getOrdersByCond(orders);
            double total = 0;
            for (Orders x : list) {
                total += Double.parseDouble(x.getMoney());
            }
            int num = list.size();
            allnum += num;
            money += total;
            html += "<tr class=\"text-c\"><td>" + (i + 1) + "</td><td>" + nxtDay + "</td><td>" + num + "</td><td>"
                    + total + "</td></tr>";
        }
        html += "<tr class=\"text-c\"><td>&nbsp;</td><td>合计</td><td>" + allnum + "</td><td>" + money + "</td></tr>";
        this.getRequest().setAttribute("html", html);
        return "admin/monthtotal";
    }

    @RequestMapping("daytotal.action")
    public String daytotal() {
        String firstDay = this.getRequest().getParameter("day1");
        String enday = this.getRequest().getParameter("day2");
        long days = VeDate.getDays(enday, firstDay) + 1;
        double money = 0;
        double allnum = 0;
        String html = "";
        for (int i = 0; i < days; i++) {
            String nxtDay = VeDate.getNextDay(firstDay, "" + i);
            Orders orders = new Orders();
            orders.setOrderdate(nxtDay);
            List<Orders> list = this.ordersService.getOrdersByCond(orders);
            double total = 0;
            for (Orders x : list) {
                total += Double.parseDouble(x.getMoney());
            }
            int num = list.size();
            allnum += num;
            money += total;
            html += "<tr class=\"text-c\"><td>" + (i + 1) + "</td><td>" + nxtDay + "</td><td>" + num + "</td><td>"
                    + total + "</td></tr>";
        }
        html += "<tr class=\"text-c\"><td>&nbsp;</td><td>合计</td><td>" + allnum + "</td><td>" + money + "</td></tr>";
        this.getRequest().setAttribute("html", html);
        return "admin/daytotal";
    }

    // 通过主键删除数据
    @RequestMapping("deleteOrders.action")
    public String deleteOrders(String id) {
        this.ordersService.deleteOrders(id);
        return "redirect:/orders/getAllOrders.action";
    }

    // 批量删除数据
    @RequestMapping("deleteOrdersByIds.action")
    public String deleteOrdersByIds() {
        String[] ids = this.getRequest().getParameterValues("ordersid");
        if (ids != null) {
            for (String ordersid : ids) {
                this.ordersService.deleteOrders(ordersid);
            }
        }
        return "redirect:/orders/getAllOrders.action";
    }

    // 更新数据
    @RequestMapping("updateOrders.action")
    public String updateOrders(Orders orders) {
        this.ordersService.updateOrders(orders);
        return "redirect:/orders/getAllOrders.action";
    }

    // 更新状态
    @RequestMapping("status.action")
    public String status(String id) {
        String status = "";
        Orders orders = this.ordersService.getOrdersById(id);
        if (status.equals(orders.getStatus())) {
            status = "";
        }
        orders.setStatus(status);
        this.ordersService.updateOrders(orders);
        return "redirect:/orders/getAllOrders.action";
    }

    // 显示全部数据
    @RequestMapping("getAllOrders.action")
    public String getAllOrders(String number) {
        List<Orders> ordersList = this.ordersService.getAllOrders();
        PageHelper.getPage(ordersList, "orders", null, null, 10, number, this.getRequest(), null);
        return "admin/listorders";
    }

    @RequestMapping("getTodayOrders.action")
    public String getTodayOrders(String number) {
        String deptid = (String) this.getSession().getAttribute("deptid");
        String status = "已付款";
        Orders orders = new Orders();
        orders.setDeptid(deptid);
        orders.setStatus(status);
        orders.setOrderdate(VeDate.getStringDateShort());
        List<Orders> ordersList = this.ordersService.getOrdersByCond(orders);
        PageHelper.getUserPage(ordersList, "orders", "getTodayOrders", 10, number, this.getRequest());
        return "admin/xlistorders";
    }

    // 按条件查询数据 (模糊查询)
    @RequestMapping("queryOrdersByCond.action")
    public String queryOrdersByCond(String cond, String name, String number) {
        Orders orders = new Orders();
        if (cond != null) {
            if ("ordercode".equals(cond)) {
                orders.setOrdercode(name);
            }
            if ("usersid".equals(cond)) {
                orders.setUsersid(name);
            }
            if ("deptid".equals(cond)) {
                orders.setDeptid(name);
            }
            if ("cateid".equals(cond)) {
                orders.setCateid(name);
            }
            if ("money".equals(cond)) {
                orders.setMoney(name);
            }
            if ("orderdate".equals(cond)) {
                orders.setOrderdate(name);
            }
            if ("symptoms".equals(cond)) {
                orders.setSymptoms(name);
            }
            if ("status".equals(cond)) {
                orders.setStatus(name);
            }
        }

        List<String> nameList = new ArrayList<String>();
        List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryorders";
    }

    // 按主键查询数据
    @RequestMapping("getOrdersById.action")
    public String getOrdersById(String id) {
        Orders orders = this.ordersService.getOrdersById(id);
        this.getRequest().setAttribute("orders", orders);
        List<Users> usersList = this.usersService.getAllUsers();
        this.getRequest().setAttribute("usersList", usersList);
        List<Dept> deptList = this.deptService.getAllDept();
        this.getRequest().setAttribute("deptList", deptList);
        List<Cate> cateList = this.cateService.getAllCate();
        this.getRequest().setAttribute("cateList", cateList);
        return "admin/editorders";
    }

}
