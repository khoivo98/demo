package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.IRoleService;
@RestController
public class RoleAPI {
	@Autowired
	private IRoleService roleService;
	
	
	@PostMapping(value = "/api/role")
	   public RoleDTO createRole(@RequestBody RoleDTO model) {
	      return roleService.save(model);
	}
	
	
	@PutMapping(value = "/api/role")
	   public RoleDTO updateRole(@RequestBody RoleDTO model) {
	      return roleService.save(model);
	}
	
	@DeleteMapping(value = "/api/role")
	   void deleteRole(@RequestBody long[] ids) {
		roleService.deleteRole(ids);
	}
}
