package com.solar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class InstallationRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long reqid ;
	long residentContactID;
	String systemType;
	String capacityinKW;
	String reqDate;
	String subsidyReq;
	String reqstatus;
	public long getReqid() {
		return reqid;
	}
	public void setReqid(long reqid) {
		this.reqid = reqid;
	}
	public long getResidentContactID() {
		return residentContactID;
	}
	public void setResidentContactID(long residentContactID) {
		this.residentContactID = residentContactID;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getCapacityinKW() {
		return capacityinKW;
	}
	public void setCapacityinKW(String capacityinKW) {
		this.capacityinKW = capacityinKW;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getSubsidyReq() {
		return subsidyReq;
	}
	public void setSubsidyReq(String subsidyReq) {
		this.subsidyReq = subsidyReq;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public InstallationRequest(long reqid, long residentContactID, String systemType, String capacityinKW,
			String reqDate, String subsidyReq, String reqstatus) {
		super();
		this.reqid = reqid;
		this.residentContactID = residentContactID;
		this.systemType = systemType;
		this.capacityinKW = capacityinKW;
		this.reqDate = reqDate;
		this.subsidyReq = subsidyReq;
		this.reqstatus = reqstatus;
	}
	public InstallationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InstallationRequest [reqid=" + reqid + ", residentContactID=" + residentContactID + ", systemType="
				+ systemType + ", capacityinKW=" + capacityinKW + ", reqDate=" + reqDate + ", subsidyReq=" + subsidyReq
				+ ", reqstatus=" + reqstatus + "]";
	}
	
	
}
