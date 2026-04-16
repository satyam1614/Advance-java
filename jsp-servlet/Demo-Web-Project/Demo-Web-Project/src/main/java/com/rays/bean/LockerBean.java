package com.rays.bean;

import java.math.BigDecimal;

public class LockerBean {
	
	private long lockerId;
	private String lockerNumber;
	private String lockerType;
	private BigDecimal annualFee;
	
	
	
	public long getLockerId() {
		return lockerId;
	}
	public void setLockerId(long lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public BigDecimal getAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(BigDecimal annualFee) {
		this.annualFee = annualFee;
	}

}
