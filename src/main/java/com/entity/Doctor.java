package com.entity;

import com.util.VeDate;

public class Doctor {
	private String doctorid = "D" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String doctorname;// 医生姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String image;// 照片
	private String deptid;// 所在科室
	private String graduate;// 毕业院校
	private String xueli;// 学历
	private String duty;// 职务
	private String contents;// 医生介绍
	private String deptname;// 映射数据

	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorname() {
		return this.doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getGraduate() {
		return this.graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getXueli() {
		return this.xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Doctor [doctorid=" + this.doctorid + ", username=" + this.username + ", password=" + this.password + ", doctorname="
				+ this.doctorname + ", sex=" + this.sex + ", birthday=" + this.birthday + ", image=" + this.image + ", deptid=" + this.deptid
				+ ", graduate=" + this.graduate + ", xueli=" + this.xueli + ", duty=" + this.duty + ", contents=" + this.contents
				+ ", deptname=" + this.deptname + "]";
	}

}
