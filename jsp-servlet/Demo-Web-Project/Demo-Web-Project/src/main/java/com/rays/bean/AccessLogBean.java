package com.rays.bean;

import java.util.Date;

public class AccessLogBean {

	private int id;
	private String accessLogCode;
	private String userName;
	private Date accessTime;
	private String status;
	private Date dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessLogCode() {
		return accessLogCode;
	}

	public void setAccessLogCode(String accessLogCode) {
		this.accessLogCode = accessLogCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
