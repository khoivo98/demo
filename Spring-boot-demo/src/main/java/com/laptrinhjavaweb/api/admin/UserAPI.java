package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	
	@PostMapping(value = "/api/user")
	   public UserDTO createUser(@RequestBody UserDTO model) {
	      return userService.save(model);
	}
	
	
	@PutMapping(value = "/api/user")
	   public UserDTO updateUser(@RequestBody UserDTO model) {
	      return userService.save(model);
	}
	
	@DeleteMapping(value = "/api/user")
	   void deleteUser(@RequestBody long[] ids) {
		userService.deleteUser(ids);
	}
}
