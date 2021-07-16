package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	@Transactional
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item : entities) {
			result.add(mapper.map(item, UserDTO.class));
		}
		return result;
	}

	@Override
	@Transactional
	public void deleteUser(long[] ids) {
		for (long item : ids) {
			userRepository.deleteById(item);
		}
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity entity = new UserEntity();
		if (dto.getId() != null) {
			// cap nhat
			entity = userRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto, UserEntity.class);
		entity = userRepository.save(entity);
		UserDTO result = mapper.map(entity, UserDTO.class);
		return result;
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findById(id).get();
		UserDTO dto = mapper.map(entity, UserDTO.class);
		return dto;
	}

}
