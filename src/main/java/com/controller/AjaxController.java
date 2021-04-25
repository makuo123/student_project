package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Doctor;
import com.service.DoctorService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxController extends BaseController {
	@Autowired
	private DoctorService doctorService;

	// 通过Ajax技术获取医生信息
	@RequestMapping("getDoctor.action")
	@ResponseBody
	public String getDoctor() {
		String id = this.getRequest().getParameter("id");
		Doctor x = new Doctor();
		x.setDeptid(id);// 加载科室信息
		List<Doctor> doctorList = this.doctorService.getDoctorByCond(x);// 查询符合条件的医生
		JSONArray doctorid = new JSONArray();
		JSONArray doctorname = new JSONArray();
		for (Doctor major : doctorList) {
			doctorid.add(major.getDoctorid());
			doctorname.add(major.getDoctorname());
		}
		JSONObject json = new JSONObject();
		json.put("doctorid", doctorid.toString().replaceAll("\"", ""));
		json.put("doctorname", doctorname.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();// 返回
	}

}
