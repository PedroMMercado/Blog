package com.noobcoder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noobcoder.model.Blog;
import com.noobcoder.service.BlogService;

@Controller
public class HomeController {
	
	@Autowired
	BlogService blogService;
	
	// Displays the Last 6 most recent post
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index(Model model,@RequestParam(value = "pageNumber", required = false) Integer pageNumber){
		// No parameter provided if null
		if(pageNumber == null)
			pageNumber = 0;
		
		int temp = pageNumber * 6;
		// Get 6 or less results from the database
		// temp should be the offset
		List<Blog> list = blogService.getAll(temp);
		
		// Check if Blog list is empty if so signal to front page that there are no page results
		// to be shown
		if(list.isEmpty()){
			model.addAttribute("error", 1);
			return "index";
		}
		
		// List for each row on front page
		List<Blog> temp1 = new ArrayList<Blog>();
		List<Blog> temp2 = new ArrayList<Blog>();
		for(int i = 0; i < list.size();i++){
			if(i < 3)
				temp1.add(list.get(i));
			else
				temp2.add(list.get(i));
		}
		
		// If temp2 is not equal to 3 there are no more blog post
		// to show on our front page
		if(temp2.size() != 3){
			model.addAttribute("nomorepages", true);
		}
		// Starting page number is 0. If less than 0 there
		// is no previous button for our front page
		if(pageNumber - 1 < 0)
			model.addAttribute("previousPage",false);
		
		model.addAttribute("pageNumberNext", pageNumber + 1);
		model.addAttribute("pageNumberPrevious", pageNumber - 1);
		model.addAttribute("temp1", temp1);
		model.addAttribute("temp2", temp2);
		return "index";
	}
}
