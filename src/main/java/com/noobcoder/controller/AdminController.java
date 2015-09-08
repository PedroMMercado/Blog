package com.noobcoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/{suspend}/{user}",method=RequestMethod.GET)
	public String admin(Model model, @PathVariable("suspend") String suspend, @RequestParam("user") String username){
		// todo make a way to suspend user.
		// update users set enabled = 1 where username = 'pedro'
		return "admin";
	}
}
