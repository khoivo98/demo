package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRoleService;
@Service
public class RoleService implements IRoleService {

	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> result = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for (RoleEntity item : entities) {
			result.add(mapper.map(item, RoleDTO.class));
		}
		return result;
	}

	@Override
	@Transactional
	public void deleteRole(long[] ids) {
		for (long item : ids) {
			roleRepository.deleteById(item);
		}
	}

	@Override
	@Transactional
	public RoleDTO save(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		if (dto.getId() != null) {
			// cap nhat
			entity = roleRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto, RoleEntity.class);
		entity = roleRepository.save(entity);
		RoleDTO result = mapper.map(entity, RoleDTO.class);
		return result;
	}

	@Override
	public RoleDTO findById(Long id) {
		RoleEntity entity = roleRepository.findById(id).get();
		RoleDTO dto = mapper.map(entity, RoleDTO.class);
		return dto;
	}

}
