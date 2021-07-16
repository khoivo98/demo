package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.RoleDTO;

public interface IRoleService {
	List<RoleDTO> findAll();
	void deleteRole(long[] ids);
	RoleDTO save(RoleDTO dto);
	RoleDTO findById(Long id);
}
