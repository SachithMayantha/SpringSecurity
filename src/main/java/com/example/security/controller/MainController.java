package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		System.out.println("return main view");
		return "main.jsp";
	}

	@RequestMapping("/login")
	public String login(){
		System.out.println("return login view");
		return "login.jsp";
	}

	@RequestMapping("/logout")
	public String logout(){
		return "logout.jsp";
	}
}
