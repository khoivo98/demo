package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@RestController
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	@GetMapping(value = "/api/product")
	public newoutput showNew(@RequestParam(value = "page", required = false) Integer page,
							 @RequestParam(value = "limit", required = false) Integer limit) {
	
	newoutput result = new newoutput();
	if(page != null & limit != null) {
		result.setPage(page);
		PageRequest pageable =   PageRequest.of(page - 1, limit);
		result.setListResult(productService.finAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (productService.totalItem()) / limit));
	}else {
		result.setListResult(productService.findAll());
	}
	
	return result;
  }
	
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
