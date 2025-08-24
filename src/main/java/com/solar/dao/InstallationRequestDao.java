package com.solar.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.solar.model.InstallationRequest;

public class InstallationRequestDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public long inserINstallationRequest(InstallationRequest installationRequest){
		long i = (Long) this.hibernateTemplate.save(installationRequest);
		return i;
	}
	
	public List<InstallationRequest> viewAllRequest(){
		List<InstallationRequest> requests = this.hibernateTemplate.loadAll(InstallationRequest.class);
		return requests;
	}
	@Transactional
	public void updateStatusApproved(long reqid){
		InstallationRequest installationRequest = this.hibernateTemplate.get(InstallationRequest.class, reqid);
		installationRequest.setReqstatus("Approved");
		this.hibernateTemplate.update(installationRequest);
	}
	
	@Transactional
	public void updateStatusReject(long reqid){
		InstallationRequest installationRequest = this.hibernateTemplate.get(InstallationRequest.class, reqid);
		installationRequest.setReqstatus("Rejected");
		this.hibernateTemplate.update(installationRequest);
	}
	
	@Transactional
	public void deleteRequests(long reqid){
		InstallationRequest request = this.hibernateTemplate.get(InstallationRequest.class, reqid);
		this.hibernateTemplate.delete(request);
	}
	
	
	
}
