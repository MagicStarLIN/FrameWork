package com.lcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcl.service.UserService;

@Controller
@RequestMapping("/loginmapper")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/loginstart")
	public String LoginStart(HttpServletRequest req){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean result = false;
		
		try {
			result =  userService.queryUserLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result==false) {
			return "bye";
		} else {
			return "hello";
		}
		
	
	}
}
