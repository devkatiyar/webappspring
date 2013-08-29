package com.springsecurity.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/home")
	public String home() {
		logger.info("webcontroller");
		return "home";
	}
}