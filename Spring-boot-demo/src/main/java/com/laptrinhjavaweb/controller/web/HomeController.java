package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/layout");
		return mav;
	}

	// trang login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("/login/login");
		return mav;
	}
	
	
	
	//dang nhap loi khi vao trang admin
		@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		public ModelAndView accessDenied() {
			return new ModelAndView("redirect:/login?accessDenied");
		}
}
