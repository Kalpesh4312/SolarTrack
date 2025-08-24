package com.solar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
public class Resident {
	String rname;
	String rAddress;
	@Column(unique=true)
	String remail;
	@Id
	long rcontact;
	long radhar;
	String rpassword;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public long getRcontact() {
		return rcontact;
	}
	public void setRcontact(long rcontact) {
		this.rcontact = rcontact;
	}
	public long getRadhar() {
		return radhar;
	}
	public void setRadhar(long radhar) {
		this.radhar = radhar;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	public Resident(String rname, String rAddress, String remail, long rcontact, long radhar, String rpassword) {
		super();
		this.rname = rname;
		this.rAddress = rAddress;
		this.remail = remail;
		this.rcontact = rcontact;
		this.radhar = radhar;
		this.rpassword = rpassword;
	}
	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Resident [rname=" + rname + ", rAddress=" + rAddress + ", remail=" + remail + ", rcontact=" + rcontact
				+ ", radhar=" + radhar + ", rpassword=" + rpassword + "]";
	}
	
	
}
