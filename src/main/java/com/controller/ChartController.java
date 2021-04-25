package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Orders;
import com.service.OrdersService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private OrdersService ordersService;

	@RequestMapping("getNum.action")
	@ResponseBody
	public String getNum() {
		String start = VeDate.getStringDateShort();
		String end = VeDate.getNextDay(start, "-7");
		long days = VeDate.getDays(start, end) + 1;
		JSONArray total = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "" + i);
			System.out.println(nxtDay);
			Orders orders = new Orders();
			orders.setOrderdate(nxtDay);
			List<Orders> list = this.ordersService.getOrdersByCond(orders);
			double sellTotal = 0;
			double sellCount = 0;
			for (Orders x : list) {
				sellTotal += Double.parseDouble(x.getMoney());
			}
			sellCount = list.size();
			total.add(VeDate.getDouble(sellTotal));
			count.add(sellCount);
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("sellTotal", total.toString());
		json.put("sellCount", count.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

}
