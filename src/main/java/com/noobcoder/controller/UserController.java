package com.noobcoder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noobcoder.model.User;
import com.noobcoder.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void setUserCreationService(UserService userCreationService){
		this.userService = userCreationService;
	}
	
	// Get data to create a user and saves into database
	@RequestMapping(value="createUser",method = RequestMethod.POST)
	public String createAccount(@Valid@ModelAttribute("user") User user, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("error", 1);
			return "accountCreation";
		}
		else
			userService.create(user);
		return"redirect:accountSuccess?username=" + user.getUserName();
	}
	
	@RequestMapping(value="createUser",method = RequestMethod.GET)
	public String createAccount(Model model){
		model.addAttribute("user", new User());
		return "accountCreation";
	}
	// To be displayed if user successfully creates an account
	@RequestMapping(value="accountSuccess",method = RequestMethod.GET)
	public String accountSuccess(Model model, @RequestParam("username") String username){
		model.addAttribute("username", username);
		return "accountSuccess";
	}
	
}
