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

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller
@PreAuthorize( "hasAuthority ('ADMIN')" )
public class RoleController {
	@Autowired
	private IRoleService roleService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/role-list", method = RequestMethod.GET)
	public ModelAndView showListRole(HttpServletRequest request) {

		RoleDTO model = new RoleDTO();
		ModelAndView mav = new ModelAndView("/admin/fragments/role/list");
		// get thong bao
		if (request.getParameter("message") != null) {
			Map<String, String> messageMap = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", messageMap.get("message"));
			mav.addObject("alert", messageMap.get("alert"));
		}
		model.setListResult(roleService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/role-edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/fragments/role/edit");

		RoleDTO model = new RoleDTO();
		if (id != null) {
			model = roleService.findById(id);
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
