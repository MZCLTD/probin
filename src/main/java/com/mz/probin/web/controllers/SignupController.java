package com.mz.probin.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.probin.dao.GenericDao;
import com.mz.probin.entities.security.AppUser;
import com.mz.probin.entities.security.AppUserRole;
import com.mz.probin.service.security.UserManager;

@Controller
public class SignupController {
	
	@Autowired
	GenericDao genericDao;
	
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value={"/signup"}, method = RequestMethod.GET)
	public String signup(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String message = ServletRequestUtils.getStringParameter(request, "mess");
		
		AppUser appUser = new AppUser();
		appUser.setMessage(message);
		
		model.addAttribute("au", appUser);
		
		return "signup";
		
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignup(@ModelAttribute AppUser au, Model model) throws Exception {
		
		// lets make sure the username is unique
		List<AppUser> appuserList = genericDao.getEntityListByStringValue("username", au.getUsername(), AppUser.class);
		
		if(appuserList.size() > 0 ){
			// user exists do
			au.setMessage("User already exists!");
			return "redirect:signup?mess="+au.getMessage();
		}
		
		if(!au.getPassword().equals(au.getRePassword())){
			au.setMessage("Password dont match!");
			return "redirect:signup?mess="+au.getMessage();
		}
		
		
		AppUserRole role = genericDao.getEntityById(AppUserRole.class, 1L);
		
		// create the user account
		au.setRole(role);
		au.setEnabled(true);
		genericDao.persist(au);
		
		// save user password
		userManager.createOrEditUser(au);
		
		// create user role
		
		
		
		return "redirect:signup-success";
		
	}
	
}
