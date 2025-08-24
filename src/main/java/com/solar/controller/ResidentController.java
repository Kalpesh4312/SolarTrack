package com.solar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solar.dao.ResidentDao;
import com.solar.model.Installation;
import com.solar.model.Resident;

@Controller
public class ResidentController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ResidentDao residentDao = (ResidentDao) context.getBean("residentDao");
	
	@RequestMapping("/resident_dashboard")
	public String residentDashBoard(Model m,HttpServletRequest request){
		m.addAttribute(request.getParameter("contactID"));
		return "resident_dashboard";
	}
	
	
	@RequestMapping(path="/ResidentLogIn",method=RequestMethod.POST)
	public String residentLogIn(HttpServletRequest request,Model m){
		
		long contactID = Long.parseLong(request.getParameter("contactID"));
		String password = request.getParameter("password");
		Resident resident = residentDao.getResidentbyContact(contactID);
		if(resident != null){
			String pass = resident.getRpassword();
			if (password.equals(pass)) {
				m.addAttribute("contactID",contactID);
				return "resident_dashboard";
			} else {
				return "index";
			}
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/view_residents")
	public String viewAllResidentshere(Model m,HttpServletRequest request){
		System.out.println("View resident Page ContactID : "+request.getAttribute("contactID"));
		List<Resident> residents = residentDao.viewAllResident();
		m.addAttribute("residents",residents);
		return "view_residents";
	}
	
	
	
	
	
}
