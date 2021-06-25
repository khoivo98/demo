package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IcategoryService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller
public class HomeController {
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/admin/fragments/home");
		return mav;
	}

	@Autowired
	private IcategoryService categoryService;

	@Autowired
	private IProductService productService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
	public ModelAndView showListProduct(HttpServletRequest request) {

		ProductDTO model = new ProductDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/product/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(productService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/product-edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/product/edit");

		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
		}
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model); // "model": cái để đẩy ra view
		return mav;
	}
}
