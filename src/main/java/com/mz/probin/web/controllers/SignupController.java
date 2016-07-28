package com.mz.probin.web.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class SignupController {/*
	
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value={"/signup"}, method = RequestMethod.GET)
	public String signup(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		UserAccount ua = new UserAccount();
		Title title = new Title();
		Gender gender = new Gender();
		
		*//*title.setTitleId(1);
		title.setTitle("Mr");
		gdao.saveObject(title);
		
		gender.setGenderId(1);
		gender.setGender("Male");
		gdao.saveObject(gender);*//*
		
		List<Title> titleList = gdao.getAll(Title.class);
		List<Gender> genderList = gdao.getAll(Gender.class);
		
		ua.setTitleList(titleList);
		ua.setGenderList(genderList);
		
		System.out.println("Title List Size :"+ua.getTitleList().size());
		System.out.println("Gender List Size :"+ua.getGenderList().size());
		
		ua.setTitleList(titleList);
		ua.setGenderList(genderList);
		
		model.addAttribute("ua", ua);
		
        return "signup";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignup(@ModelAttribute UserAccount ua, Model model) throws Exception {
		
		*//*AuthenticationUtils auth = new AuthenticationUtils();
		String token = auth.getAuthenticationToken(Constants.USERNAME, Constants.PASSWORD, Constants.VAULTGUID);*//*
		
		// Save user record and send email for confirmation
		gdao.saveObject(ua);
		
		// create user account
		Users users = new Users();
		users.setEnabled(1);
		users.setPassword(ua.getPassword());
		users.setUsername(ua.getUsername());
		
		gdao.saveObject(users);
		
		// Create user role
		UserRoles ur = new UserRoles();
		ur.setUsername(ua.getUsername());
		ur.setRole(Constants.USER_ROLE);
		
		gdao.saveObject(ur);
		
        return "signup-success";
		
	}
	
*/}
