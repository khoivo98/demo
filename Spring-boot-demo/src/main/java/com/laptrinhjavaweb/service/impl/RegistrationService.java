package com.laptrinhjavaweb.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dto.UserRegistrationDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IRegistrationService;

@Service
public class RegistrationService implements IRegistrationService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	private final ModelMapper mapper = new ModelMapper();
	
	@Override
	@Transactional
	public UserRegistrationDTO save(UserRegistrationDTO registrationDTO) {
		//
		UserEntity entity = mapper.map(registrationDTO, UserEntity.class);
		entity.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		entity.setStatus(1);
		entity.setRoles(Arrays.asList(roleRepository.findByName("USER")));
		entity = userRepository.save(entity);
		//
		UserRegistrationDTO result =  mapper.map(entity, UserRegistrationDTO.class);
		return result;
	}

	@Override
	public UserEntity findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
