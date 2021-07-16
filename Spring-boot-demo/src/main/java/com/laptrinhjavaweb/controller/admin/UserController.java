package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;
@Controller
@PreAuthorize( "hasAuthority ('ADMIN')" )
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
	public ModelAndView showListUser(HttpServletRequest request) {

		UserDTO model = new UserDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/user/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(userService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/user-edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/user/edit");

		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);
		}
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		mav.addObject("listRoles",roleService.findAll());
		mav.addObject("model", model); // "model": cái để đẩy ra view
		return mav;
	}
}
