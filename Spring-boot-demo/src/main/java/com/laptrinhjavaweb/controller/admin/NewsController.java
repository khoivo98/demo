package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.NewsDTO;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.service.IcategoryService;
import com.laptrinhjavaweb.util.MessageUtil;
@Controller
public class NewsController {
	@Autowired
	private INewsService newsService;
	@Autowired
	private IcategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/news-list", method = RequestMethod.GET)
	public ModelAndView showListNews(HttpServletRequest request) {

		NewsDTO model = new NewsDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/news/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(newsService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/news-edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/news/edit");

		NewsDTO model = new NewsDTO();
		if (id != null) {
			model = newsService.findById(id);
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
