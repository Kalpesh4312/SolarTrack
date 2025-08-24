package com.solar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long reportID;
	long installationID;
	String powerGenerated;
	String reportDate;
	String maintananceNote;
	public long getReportID() {
		return reportID;
	}
	public void setReportID(long reportID) {
		this.reportID = reportID;
	}
	public long getInstallationID() {
		return installationID;
	}
	public void setInstallationID(long installationID) {
		this.installationID = installationID;
	}
	public String getPowerGenerated() {
		return powerGenerated;
	}
	public void setPowerGenerated(String powerGenerated) {
		this.powerGenerated = powerGenerated;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getMaintananceNote() {
		return maintananceNote;
	}
	public void setMaintananceNote(String maintananceNote) {
		this.maintananceNote = maintananceNote;
	}
	public Report(long reportID, long installationID, String powerGenerated, String reportDate,
			String maintananceNote) {
		super();
		this.reportID = reportID;
		this.installationID = installationID;
		this.powerGenerated = powerGenerated;
		this.reportDate = reportDate;
		this.maintananceNote = maintananceNote;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Report [reportID=" + reportID + ", installationID=" + installationID + ", powerGenerated="
				+ powerGenerated + ", reportDate=" + reportDate + ", maintananceNote=" + maintananceNote + "]";
	}
	
}
