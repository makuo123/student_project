package com.entity;

public class Work {
	private String worksid;
	private String wno;
	private String doctorid;
	private String doctorname;
	private String workdate;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorksid() {
		return worksid;
	}

	public void setWorksid(String worksid) {
		this.worksid = worksid;
	}

	public String getWno() {
		return wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
	}

	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

}
