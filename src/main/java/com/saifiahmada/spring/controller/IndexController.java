package com.saifiahmada.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

}
