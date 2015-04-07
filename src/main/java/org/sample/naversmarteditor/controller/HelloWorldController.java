package org.sample.naversmarteditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "hello world");

		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "2")
	public ModelAndView helloWorld2() {

		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "hello world III");

		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "3")
	public ModelAndView helloWorld3() {

		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "hello world III");

		return model;
	}
}