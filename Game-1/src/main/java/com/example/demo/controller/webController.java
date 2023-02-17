package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {

	
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
	

	
	
}
