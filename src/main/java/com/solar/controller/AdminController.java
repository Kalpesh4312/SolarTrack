package com.solar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solar.dao.ResidentDao;
import com.solar.model.Resident;

@Controller
public class AdminController {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Resident resident = (Resident) context.getBean("resident");
	ResidentDao residentDao = (ResidentDao) context.getBean("residentDao");
	
	@RequestMapping("/")
	public String openHome(){
		return "index";
	}
	@RequestMapping("/index")
	public String openHomePage(){
		return "index";
	}
	
	@RequestMapping("/admin_dashboard")
	public String adminDashBoard(){
		return "admin_dashboard";
	}
	
	@RequestMapping(path="/AdminLogIn",method=RequestMethod.POST)
	public String adminLogin(HttpServletRequest request){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("Admin@gmail.com")&&password.equals("4312")){
			System.out.println("Admin LogIN Successfully ");
			return "admin_dashboard";
		} else {
			System.out.println("Admin Not LogIN  ");
			return "error";
		}
	}
	
	
	
	@RequestMapping("/resident_register")
	public String residentsRegisterPage(){		
		System.out.println("Resident Register Open");
		return "resident_register";
	}
	
	@RequestMapping("/add_register")
	public String add_register(HttpServletRequest request){
		resident.setRname(request.getParameter("rname"));
		resident.setrAddress(request.getParameter("raddress"));
		resident.setRemail(request.getParameter("remail"));
		resident.setRcontact(Long.parseLong(request.getParameter("rcontact")));
		resident.setRadhar(Long.parseLong(request.getParameter("radhar")));
		resident.setRpassword(request.getParameter("rpassword"));
		long i = residentDao.insertResident(resident);
		if(i>0){
			System.out.println("Resident inserted ");
			return "index";
		} else {
			System.out.println("Resident is not inserted");
			return "resident_register";
		}
		
	}
	
	
	@RequestMapping("/error")
	public String errorHasOCcured(){
		return "error";
	}
		
	
	
}
