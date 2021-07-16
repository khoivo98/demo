package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.IcategoryService;
@RestController

public class CategoryAPI {
	@Autowired
	private IcategoryService categoryService;
	
	
	@PostMapping(value = "/api/category")
	   public CategoryDTO createCategory(@RequestBody CategoryDTO model) {
	      return categoryService.save(model);
	}
	
	
	@PutMapping(value = "/api/category")
	   public CategoryDTO updateCategory(@RequestBody CategoryDTO model) {
	      return categoryService.save(model);
	}
	
	
	@DeleteMapping(value = "/api/category")
	@PreAuthorize( "hasAuthority ('ADMIN')" )
	   void deleteCategory(@RequestBody long[] ids) {
		categoryService.deleteCategory(ids);
	}
}
