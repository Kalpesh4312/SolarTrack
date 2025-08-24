package com.solar.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solar.dao.InstallationRequestDao;
import com.solar.model.Installation;
import com.solar.model.InstallationRequest;

@Controller
public class InstallationRequestController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	InstallationRequestDao installationRequestDao = (InstallationRequestDao) context.getBean("installationRequestDao");
	InstallationRequest installationRequest = (InstallationRequest) context.getBean("installationRequest");
	
	@RequestMapping("/apply_installations")
	public String applyINstallations(){
		return "apply_installations";
	}
	LocalDate ld = LocalDate.now();
	
	@RequestMapping(path="/applyforINstallationrequest",method=RequestMethod.POST)
	public String appyInstallationRequest(HttpServletRequest request,Model m){
		String solarType = request.getParameter("solarType");
		String capacityKW = request.getParameter("capacityKW");
		String subsidyreq = request.getParameter("subsidyreq");
		System.out.println(request.getParameter("contactID"));
		installationRequest.setReqid(0);
		installationRequest.setResidentContactID(Long.parseLong(request.getParameter("contactID")));
		installationRequest.setSystemType(solarType);
		installationRequest.setCapacityinKW(capacityKW);
		installationRequest.setSubsidyReq(subsidyreq);
		installationRequest.setReqDate(ld.toString());
		installationRequest.setReqstatus("pending");
		long l = installationRequestDao.inserINstallationRequest(installationRequest);
		if(l>0){
			m.addAttribute("contactID",Long.parseLong(request.getParameter("contactID")));
			System.out.println("Insrtallation Request is Addeed ");
			return "resident_dashboard";
		} else {
			System.out.println("Installation request is not Added");
			return "apply_installations";
		}
	}
	
	@RequestMapping("/approve_reject_installation_request")
	public String aproverejectINstallationRequest(Model m){
		List<InstallationRequest> requests = installationRequestDao.viewAllRequest();
		m.addAttribute("requests",requests);
		return "approve_reject_installation_request";
	}
	
	@RequestMapping(path="/approve")
	public String approveStatus(HttpServletRequest request){
		String reqid = request.getParameter("reqid");
		installationRequestDao.updateStatusApproved(Long.parseLong(reqid));
		return "redirect:/approve_reject_installation_request";
	}
	
	@RequestMapping("/reject")
	public String rejectStatus(HttpServletRequest request){
		String reqid = request.getParameter("reqid");
		installationRequestDao.updateStatusReject(Long.parseLong(reqid));
		return "redirect:/approve_reject_installation_request";
	}
	
	@RequestMapping("/view_application_status")
	public String viewApplicationStatus(Model m,HttpServletRequest request){
		
		long contactID = Long.parseLong(request.getParameter("contactID"));
		List<InstallationRequest> request1 = (List<InstallationRequest>) installationRequestDao.viewAllRequest();
		m.addAttribute("requests",request1);
		
		return "view_application_status";
	}
	
	@RequestMapping(path="/deleterequest",method=RequestMethod.POST)
	public String deleteRequest(HttpServletRequest request,Model m){
		long reqid = Long.parseLong(request.getParameter("reqID"));
		installationRequestDao.deleteRequests(reqid);
		return "redirect:/view_application_status";
	}
	
	@RequestMapping("/view_approved_installation_request")
	public String viewApprovedInstallationRequest(Model m){
		List<InstallationRequest> ir =  installationRequestDao.viewAllRequest();
		m.addAttribute("requests",ir);
		
		return "view_approved_installation_request";
	}
	

	
	
	
}
