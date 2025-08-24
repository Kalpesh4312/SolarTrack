package com.solar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Installer {
	String iname;
	String ilicense;
	@Column(unique=true)
	String iemail;
	@Id
	long icontact;
	String ipassword;
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIlicense() {
		return ilicense;
	}
	public void setIlicense(String ilicense) {
		this.ilicense = ilicense;
	}
	public String getIemail() {
		return iemail;
	}
	public void setIemail(String iemail) {
		this.iemail = iemail;
	}
	public long getIcontact() {
		return icontact;
	}
	public void setIcontact(long icontact) {
		this.icontact = icontact;
	}
	public String getIpassword() {
		return ipassword;
	}
	public void setIpassword(String ipassword) {
		this.ipassword = ipassword;
	}
	public Installer(String iname, String ilicense, String iemail, long icontact, String ipassword) {
		super();
		this.iname = iname;
		this.ilicense = ilicense;
		this.iemail = iemail;
		this.icontact = icontact;
		this.ipassword = ipassword;
	}
	public Installer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Installer [iname=" + iname + ", ilicense=" + ilicense + ", iemail=" + iemail + ", icontact=" + icontact
				+ ", ipassword=" + ipassword + "]";
	}
	
	
}
