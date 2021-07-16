package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.util.MessageUtil;
@Controller
public class CommentController {
	@Autowired
	private ICommentService commentService;
	@Autowired
	private INewsService newsService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/comment-list", method = RequestMethod.GET)
	public ModelAndView showListComment(HttpServletRequest request) {

		CommentDTO model = new CommentDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/comment/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(commentService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/comment-edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/comment/edit");

		CommentDTO model = new CommentDTO();
		if (id != null) {
			model = commentService.findById(id);
		}
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("listNews", newsService.findAll());
		mav.addObject("model", model); // "model": cái để đẩy ra view
		return mav;
	}
}
