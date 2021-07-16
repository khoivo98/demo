package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserRegistrationDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public interface IRegistrationService {
	UserRegistrationDTO save (UserRegistrationDTO registrationDTO);
	 UserEntity findByUserName(String userName);
}
