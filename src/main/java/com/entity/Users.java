package com.entity;

import com.util.VeDate;

public class Users {
	private String usersid = "U" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String realname;// 姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String contact;// 联系方式
	private String safesid;// 提示问题
	private String answer;// 问题答案
	private String regdate;// 注册日期
	private String safesname;// 映射数据

	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
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

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSafesid() {
		return this.safesid;
	}

	public void setSafesid(String safesid) {
		this.safesid = safesid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getSafesname() {
		return this.safesname;
	}

	public void setSafesname(String safesname) {
		this.safesname = safesname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Users [usersid=" + this.usersid + ", username=" + this.username + ", password=" + this.password + ", realname=" + this.realname
				+ ", sex=" + this.sex + ", birthday=" + this.birthday + ", contact=" + this.contact + ", safesid=" + this.safesid + ", answer="
				+ this.answer + ", regdate=" + this.regdate + ", safesname=" + this.safesname + "]";
	}

}
