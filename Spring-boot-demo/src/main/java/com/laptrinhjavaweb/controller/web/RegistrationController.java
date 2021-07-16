package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserRegistrationDTO;

@Controller

public class RegistrationController {

	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView registrationPage( UserRegistrationDTO model) {
		ModelAndView mav = new ModelAndView("/login/register");
		mav.addObject("model",model);
		return mav;
	}
}
