package com.solar.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.solar.model.Report;

public class ReportDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public long insertReport(Report report){
		long l = (Long) this.hibernateTemplate.save(report);
		
		return l;
	}
	

	public List<Report> viewAllReport(){
		List<Report> li = this.hibernateTemplate.loadAll(Report.class);
		return li;
	}
	
	public Report viewInstallationbyID(long ID){
		Report installation = this.hibernateTemplate.get(Report.class, ID);
		return installation;
	}
	
}
