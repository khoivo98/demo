package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserRegistrationDTO;
import com.laptrinhjavaweb.service.IRegistrationService;

@RestController
public class RegistrationAPI {
	@Autowired
	private IRegistrationService registrationService;

	@PostMapping(value = "api/register")
	public UserRegistrationDTO registrationUser(@RequestBody UserRegistrationDTO model) {
		return registrationService.save(model);

	}
}
