package com.solar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solar.dao.InstallerDao;
import com.solar.model.Installer;

@Controller
public class InstallerController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Installer installer = (Installer)context.getBean("installer");
	InstallerDao installerDao = (InstallerDao) context.getBean("installerDao");
	
	@RequestMapping("/installer_add")
	public String installerAdd(){
		return "installer_add";
	}
	
	@RequestMapping(path="add_installer",method=RequestMethod.POST)
	public String addInstaller(HttpServletRequest request){
		installer.setIname(request.getParameter("iname"));
		installer.setIlicense(request.getParameter("ilicense"));
		installer.setIemail(request.getParameter("iemail"));
		installer.setIcontact(Long.parseLong(request.getParameter("icontact")));
		installer.setIpassword(request.getParameter("ipassword"));
		long  i = installerDao.insertInstaller(installer);
		
		if(i>0){
			return "redirect:/add_view_delete_installers";
		} else {
			return "installer_add";
		}
		
	}
	
	@RequestMapping("/add_view_delete_installers")
	public String avdInstaller(Model m){
		System.out.println("Add/View/Delete Installers");
		m.addAttribute("installers",installerDao.viewAllInstaller());
		return "add_view_delete_installers";
	}
	
	 @RequestMapping("/delete")
	 public String deleteINstaller(HttpServletRequest request){
		 long icontact =Long.parseLong(request.getParameter("icontact"));
		 installerDao.deleteInstaller(icontact);
		 return "redirect:/add_view_delete_installers";
	 }
	
	 
	 @RequestMapping(path="/InstallerLogIn",method=RequestMethod.POST)
	 public String installerLogIN(HttpServletRequest request,Model m){
		 long contactID = Long.parseLong(request.getParameter("contactID"));
		 
		 String password = request.getParameter("password");
		 System.out.println(password);
		 Installer in = installerDao.viewInstaller(contactID);
		 if(in != null){
			 String pass = in.getIpassword();
			 
			 if(pass.equals(password)){
				 m.addAttribute("contactID",contactID);
				 return "installer_dashboard";
			 } else {
				 return "index";
			 }
		 } else {
			 return "error";
		 }
	 }
	 
	 @RequestMapping("/installer_dashboard")
	 public String instalerDashBOard(HttpServletRequest request,Model m){
		m.addAttribute("contactID",request.getParameter("contactID"));
		
		 return "installer_dashboard";
	 }
	 
	 @RequestMapping("/change_passowrd")
	 public String changePassword(){
		 return "change_passowrd";
	 }
	 
	 @RequestMapping(path="/changePAsswordofinstaller",method=RequestMethod.POST)
	 public String changepasswordFoRInstaller(HttpServletRequest request,Model m){
		 long contactID = Long.parseLong(request.getParameter("contactID"));
		 installer = installerDao.viewInstaller(contactID);
		 String oldpassword = installer.getIpassword();
		 if(oldpassword.contains(request.getParameter("oldpass")) ){
			 m.addAttribute("contactID",contactID);
			 installerDao.changePAsswordInstaller(installer, request.getParameter("newpass"));
			 return "installer_dashboard";
		 } else {
			 System.out.println("Enter Wrong Old Password");
			 return "change_passowrd";
		 }
		 
		 
	 }
	 
}
