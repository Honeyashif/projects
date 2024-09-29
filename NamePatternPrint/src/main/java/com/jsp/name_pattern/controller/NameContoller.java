package com.jsp.name_pattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.name_pattern.service.NameService;

@Controller
public class NameContoller {
	@Autowired
	private NameService nameService;
	
	@RequestMapping(value = "/print-name-pattern",method = RequestMethod.GET)
	public ModelAndView printNamePattern(String name,int size) {
		return nameService.printNamePattern(name,size);
	}
}
