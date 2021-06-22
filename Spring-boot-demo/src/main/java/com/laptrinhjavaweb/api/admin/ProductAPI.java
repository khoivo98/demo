package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@RestController
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	
	@PostMapping(value = "/api/product")
	   public ProductDTO creatProduct(@RequestBody ProductDTO model) {
	      return productService.save(model);
	}
	
	
	
	@PutMapping(value = "/api/product")
	   public ProductDTO updateProduct(@RequestBody ProductDTO model) {
	      return productService.save(model);
	}
	
	@DeleteMapping(value = "/api/product")
	   void deleteProduct(@RequestBody long[] ids) {
	      productService.deleteProduct(ids);
	}
}
