package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.IcategoryService;
import com.laptrinhjavaweb.util.MessageUtil;
@Controller
public class CategoryController {
	@Autowired
	private IcategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/category-list", method = RequestMethod.GET)
	public ModelAndView showListCategory(HttpServletRequest request) {

		CategoryDTO model = new CategoryDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/category/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/category-edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/category/edit");

		CategoryDTO model = new CategoryDTO();
		if (id != null) {
			model = categoryService.findById(id);
		}
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("model", model); // "model": cái để đẩy ra view
		return mav;
	}
}
