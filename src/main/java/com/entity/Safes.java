package com.entity;

import com.util.VeDate;

public class Safes {
	private String safesid = "S" + VeDate.getStringId();// 生成主键编号
	private String safesname;// 提示问题
	private String addtime;// 创建日期

	public String getSafesid() {
		return safesid;
	}

	public void setSafesid(String safesid) {
		this.safesid = safesid;
	}

	public String getSafesname() {
		return this.safesname;
	}

	public void setSafesname(String safesname) {
		this.safesname = safesname;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Safes [safesid=" + this.safesid + ", safesname=" + this.safesname + ", addtime=" + this.addtime + "]";
	}

}
