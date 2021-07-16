package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	void deleteUser(long[] ids);
	UserDTO save(UserDTO dto);
	UserDTO findById(Long id);
}
