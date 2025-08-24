package com.solar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Installation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long iid;
	long reqID;
	long icontactID;
	String installDate;
	long SystemCostt;
	String subsidyApproved;
	String remarks;
	public long getIid() {
		return iid;
	}
	public void setIid(long iid) {
		this.iid = iid;
	}
	public long getReqID() {
		return reqID;
	}
	public void setReqID(long reqID) {
		this.reqID = reqID;
	}
	public long getIcontactID() {
		return icontactID;
	}
	public void setIcontactID(long icontactID) {
		this.icontactID = icontactID;
	}
	public String getInstallDate() {
		return installDate;
	}
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	public long getSystemCostt() {
		return SystemCostt;
	}
	public void setSystemCostt(long systemCostt) {
		SystemCostt = systemCostt;
	}
	public String getSubsidyApproved() {
		return subsidyApproved;
	}
	public void setSubsidyApproved(String subsidyApproved) {
		this.subsidyApproved = subsidyApproved;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Installation(long iid, long reqID, long icontactID, String installDate, long systemCostt,
			String subsidyApproved, String remarks) {
		super();
		this.iid = iid;
		this.reqID = reqID;
		this.icontactID = icontactID;
		this.installDate = installDate;
		SystemCostt = systemCostt;
		this.subsidyApproved = subsidyApproved;
		this.remarks = remarks;
	}
	public Installation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Installation [iid=" + iid + ", reqID=" + reqID + ", icontactID=" + icontactID + ", installDate="
				+ installDate + ", SystemCostt=" + SystemCostt + ", subsidyApproved=" + subsidyApproved + ", remarks="
				+ remarks + "]";
	}
	
	
}
