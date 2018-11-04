package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showLanding() {
	return "landingHeaderPage";

	}

	@GetMapping("/sign")
	public String sign() {
		//return "plain-login";
		return "outer1";
	}


	
}
