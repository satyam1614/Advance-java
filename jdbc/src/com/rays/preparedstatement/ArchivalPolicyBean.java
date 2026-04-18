package com.rays.preparedstatement;

public class ArchivalPolicyBean {
	
	private  int policyId;
	private String policyCode;
	private String dataType;
	private String  archiveAfterDays;
	private String status;
	
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getArchiveAfterDays() {
		return archiveAfterDays;
	}
	public void setArchiveAfterDays(String archiveAfterDays) {
		this.archiveAfterDays = archiveAfterDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
