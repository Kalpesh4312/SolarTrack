package com.solar.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.solar.model.Installer;
import com.solar.model.Resident;


public class ResidentDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public long insertResident(Resident resident){
		long i = (Long) this.hibernateTemplate.save(resident);
		return i;
	}
	
	public Resident getResidentbyContact(long rcontact){
		Resident resident = this.hibernateTemplate.get(Resident.class, rcontact);
		return resident;
	}
	
	public List<Resident> viewAllResident(){
		List<Resident> residents = (List<Resident>)this.hibernateTemplate.loadAll(Resident.class);
		return residents;
	}
	
	
}
