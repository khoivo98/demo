package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/api/product", method = RequestMethod.GET)
	public ModelAndView showListProduct(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {

		ProductDTO model = new ProductDTO();
		ModelAndView mav = new ModelAndView("admin/fragments/product/list");
		if(page != null & limit != null) {
			model.setPage(page);
			Pageable pageable  =PageRequest.of(page -1, limit);
			model.setListResult(productService.finAll(pageable));
			model.setTotalPage((int) Math.ceil((double) (productService.totalItem()) / limit));
		}else {
			model.setListResult(productService.findAll());
		}
		mav.addObject("model", model);
		return mav;
	}
}
