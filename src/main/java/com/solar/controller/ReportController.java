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

import com.solar.dao.ReportDao;
import com.solar.model.Report;

@Controller
public class ReportController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ReportDao reportDao = (ReportDao) context.getBean("reportDao");
	Report report = (Report) context.getBean("report");
	
	
	@RequestMapping("/create_report")
	public String createReport(){
		return "create_report";
	}
	
	@RequestMapping(path="/reportcreateform",method=RequestMethod.POST)
	public String createReportForm(HttpServletRequest request){
		System.out.println("ContactID : "+request.getParameter("contactID"));
		report.setReportID(0);
		LocalDate l = LocalDate.now();
		report.setReportDate(l.toString());
		report.setPowerGenerated(request.getParameter("powerGenerated"));
		report.setMaintananceNote(request.getParameter("maintainanceNote"));
		report.setInstallationID(Long.parseLong(request.getParameter("installationID")));
		long l1 = reportDao.insertReport(report);
		if(l1>0){
			return "redirect:/mark_installation_as_complete?contactID="+request.getParameter("contactID");
		} else {
			return "create_report";
		}
	}
	
	@RequestMapping("/view_subsidy_reports")
	public String viewSubsidyReport(Model m){
		List<Report> report = reportDao.viewAllReport();
		m.addAttribute("reports",report);
		
		return "view_subsidy_reports";
	}
	
}
