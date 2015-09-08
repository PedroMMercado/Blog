package com.noobcoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noobcoder.model.User;
import com.noobcoder.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin(Model model){
		List<User> userList = userService.getAll();
		model.addAttribute("users", userList);
		return "admin";
	}
	
	@RequestMapping(value="/{enabledOrDisabled}/{user}",method=RequestMethod.GET)
	public String admin(Model model,@PathVariable("user") String username,@PathVariable("enabledOrDisabled") String enabledOrDisabled){
		if(enabledOrDisabled.equals("suspend"))
			userService.suspendOrEnable(username, 0);
		else
			userService.suspendOrEnable(username, 1);
		List<User> userList = userService.getAll();
		model.addAttribute("users", userList);
		return "admin";
	}
}
