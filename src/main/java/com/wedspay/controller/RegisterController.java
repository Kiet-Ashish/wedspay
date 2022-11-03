package com.wedspay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wedspay.entity.User;
import com.wedspay.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/registerRequest")
	public String requestRegister(Model model) {
		User user = new User();
		//System.out.println("hello ");
		model.addAttribute("user", user);
		return "UserReg";
	}
	
	@RequestMapping("/userRegister")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bind, @RequestParam(value="agg", defaultValue = "false") boolean check, Model model) {
		// use here userService.
		if(bind.hasErrors()) {
			//model.addAttribute("user", user);
			return "UserReg";
		}
		else if(!check) {
			model.addAttribute("user", user);
			return "UserReg";
		}else {
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userService.saveUser(user);
			return "redirect:/user/showMyLoginPage";
		}
	}
	@InitBinder
	public void initBinder(WebDataBinder data) {
		StringTrimmerEditor string = new StringTrimmerEditor(true);
		data.registerCustomEditor(String.class, string);
	}
}
