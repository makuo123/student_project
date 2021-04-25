package com.entity;

import com.util.VeDate;

public class Advice {
	private String adviceid = "A" + VeDate.getStringId();// 生成主键编号
	private String ordersid;// 挂号单
	private String usersid;// 用户
	private String doctorid;// 医生
	private String contents;// 医嘱内容
	private String addtime;// 日期
	private String ordercode;// 映射数据
	private String realname;// 映射数据
	private String doctorname;// 映射数据

	public String getAdviceid() {
		return adviceid;
	}

	public void setAdviceid(String adviceid) {
		this.adviceid = adviceid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getDoctorid() {
		return this.doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getDoctorname() {
		return this.doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Advice [adviceid=" + this.adviceid + ", ordersid=" + this.ordersid + ", usersid=" + this.usersid + ", doctorid=" + this.doctorid
				+ ", contents=" + this.contents + ", addtime=" + this.addtime + ", ordercode=" + this.ordercode + ", realname=" + this.realname
				+ ", doctorname=" + this.doctorname + "]";
	}

}
