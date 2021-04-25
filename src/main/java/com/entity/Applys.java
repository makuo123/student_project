package com.entity;

import com.util.VeDate;

public class Applys {
	private String applysid = "A" + VeDate.getStringId();// 生成主键编号
	private String worksid;// 排班号
	private String doctorid;// 医生
	private String reason;// 调班原因
	private String workdate;// 原日期
	private String orderdate;// 计划日期
	private String status;// 状态
	private String memo;// 备注
	private String wno;// 映射数据
	private String doctorname;// 映射数据

	public String getApplysid() {
		return applysid;
	}

	public void setApplysid(String applysid) {
		this.applysid = applysid;
	}

	public String getWorksid() {
		return this.worksid;
	}

	public void setWorksid(String worksid) {
		this.worksid = worksid;
	}

	public String getDoctorid() {
		return this.doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getWno() {
		return this.wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
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
		return "Applys [applysid=" + this.applysid + ", worksid=" + this.worksid + ", doctorid=" + this.doctorid + ", reason=" + this.reason
				+ ", workdate=" + this.workdate + ", orderdate=" + this.orderdate + ", status=" + this.status + ", memo=" + this.memo + ", wno="
				+ this.wno + ", doctorname=" + this.doctorname + "]";
	}

}
