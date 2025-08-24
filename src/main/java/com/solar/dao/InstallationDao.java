package com.solar.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.solar.model.Installation;

public class InstallationDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public long insertInstallation(Installation installation){
		long l = (Long)this.hibernateTemplate.save(installation);
		return l;
	}
	
	public List<Installation> viewAllInstallation(){
		List<Installation> li = this.hibernateTemplate.loadAll(Installation.class);
		return li;
	}
	
	public Installation viewInstallationbycontactID(long contactID){
		Installation installation = this.hibernateTemplate.get(Installation.class, contactID);
		return installation;
	}
}
