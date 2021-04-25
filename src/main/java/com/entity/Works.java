package com.entity;

import com.util.VeDate;

public class Works {
	private String worksid = "W" + VeDate.getStringId();// 生成主键编号
	private String wno;// 排班号
	private String deptid;// 科室
	private String doctorid;// 医生
	private String workdate;// 日期
	private String memo;// 备注
	private String deptname;// 映射数据
	private String doctorname;// 映射数据

	public String getWorksid() {
		return worksid;
	}

	public void setWorksid(String worksid) {
		this.worksid = worksid;
	}

	public String getWno() {
		return this.wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
	}

	public String getDoctorid() {
		return this.doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDoctorname() {
		return this.doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Works [worksid=" + this.worksid + ", wno=" + this.wno + ", deptid=" + this.deptid + ", doctorid=" + this.doctorid
				+ ", workdate=" + this.workdate + ", memo=" + this.memo + ", deptname=" + this.deptname + ", doctorname=" + this.doctorname
				+ "]";
	}

}
