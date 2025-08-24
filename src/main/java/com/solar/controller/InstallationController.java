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

import com.solar.dao.InstallationDao;
import com.solar.dao.ReportDao;
import com.solar.model.Installation;
import com.solar.model.Report;

@Controller
public class InstallationController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	InstallationDao installationDao = (InstallationDao)context.getBean(InstallationDao.class);
	Installation installation = (Installation) context.getBean(Installation.class);
	ReportDao reportDao = (ReportDao) context.getBean(ReportDao.class);
	
	
	@RequestMapping("/mark_installation_as_complete")
	public String markInstallationcomplete(Model m){
		List<Installation> li = installationDao.viewAllInstallation();
		m.addAttribute("installations",li);
		return "mark_installation_as_complete";
	}
	
	
	@RequestMapping(path="/installationmarkcomplete",method=RequestMethod.POST)
	public String installationMarkCompleteForm(HttpServletRequest request,Model m){
		installation.setIcontactID(Long.parseLong(request.getParameter("contactID")));
		installation.setIid(0);
		LocalDate l = LocalDate.now();
		installation.setInstallDate(l.toString());
		installation.setSystemCostt(Long.parseLong(request.getParameter("scost")));
		installation.setSubsidyApproved(request.getParameter("subsidyAproved"));
		installation.setReqID(Long.parseLong(request.getParameter("reqID")));
		installation.setRemarks(request.getParameter("remark"));
		long l1 = installationDao.insertInstallation(installation);
		if(l1>0){
			System.out.println("Installation mark is Completed");
			return "redirect:/mark_installation_as_complete?contactID="+request.getParameter("contactID");
		} else {
			System.out.println("Instalaltion MArking is not Completed");
			m.addAttribute("contactID", request.getParameter("contactID"));
			return "installer_dashboard";
		}
	}
	
	@RequestMapping("/view_installations_subsidy_reports")
	public String viewInstallationsAndSubsidyReport(Model m){
		List<Installation> installations = installationDao.viewAllInstallation();
		m.addAttribute("installations", installations);
		List<Report> report = reportDao.viewAllReport();
		m.addAttribute("reports",report);
		
		return "view_installations_subsidy_reports";
	}
}
