package com.solar.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.solar.model.Installer;

public class InstallerDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public long insertInstaller(Installer installer){
		long i = (Long) this.hibernateTemplate.save(installer);
		
		return i;
	}
	
	public List<Installer> viewAllInstaller(){
		List<Installer> li = this.hibernateTemplate.loadAll(Installer.class);
		return li;
	}
	
	public Installer viewInstaller(long icontact){
		Installer l = this.hibernateTemplate.get(Installer.class, icontact);
		return l;
	}
	
	@Transactional
	public void deleteInstaller(long icontact){
		Installer i = this.hibernateTemplate.get(Installer.class, icontact);
		this.hibernateTemplate.delete(i);
	}
	
	@Transactional
	public void changePAsswordInstaller(Installer installer,String password){
		
		installer.setIpassword(password);
		this.hibernateTemplate.update(installer);
	}
	
}
