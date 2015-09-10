package com.noobcoder.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.noobcoder.model.Blog;
import com.noobcoder.model.Comment;
import com.noobcoder.service.BlogService;
import com.noobcoder.service.CommentService;

@Controller	
@SessionAttributes("blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	// Get Blog data from user, persist into database
	@RequestMapping(value="/blogpost",method = RequestMethod.POST)
	public String blogCreatePost(@ModelAttribute("blog") Blog blog, Principal principal){
		String blogName = blogService.getBlogName(principal.getName());
		blog.setBlogname(blogName);
		blog.setUsername(principal.getName());
		blogService.create(blog);
		return "redirect:/posted.html";
	}
	
	@RequestMapping(value="/blogpost",method = RequestMethod.GET)
	public String blogCreatePost(Model model){
		model.addAttribute("blog", new Blog());
		return "blogpost";
	}
	
	// Indicate if User post has been successfully created
	@RequestMapping(value="/posted", method=RequestMethod.GET)
	public String successPost(){
		return "posted";
	}
	
	// Used to display profile of user
	@RequestMapping(value="/{blogname}", method=RequestMethod.GET)
	public String successPost(@PathVariable("blogname") String blogname, Model model){
		List<Blog> blog = blogService.getAllUser(blogname);
		model.addAttribute("blog", blog);
		model.addAttribute("blogURL", blogname);
		return "profile";
	}
	// Used to display particular post of user
	@RequestMapping(value="/{blogname}/{id}/{title}", method=RequestMethod.GET)
	public String homePageLinks(@PathVariable("blogname") String blogname,
								@PathVariable("id") int id ,
								@PathVariable("title") String title, Model model){
		List<Blog> blog = blogService.getByID(id);
		List<Comment> comment = commentService.getComments(id);
		for(int i = 0; i < comment.size();i++){
			System.out.println(comment.get(i));
		}
		model.addAttribute("blogID",blog);
		return "post";
	}
}
