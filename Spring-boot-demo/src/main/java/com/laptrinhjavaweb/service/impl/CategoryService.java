package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.IcategoryService;

@Service
public class CategoryService implements IcategoryService{
	
	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			result.add(mapper.map(item, CategoryDTO.class));
		}
		return result;
	}
	@Override
	public void deleteCategory(long[] ids) {
		for (long item : ids) {
			categoryRepository.deleteById(item);
		}
	}
	
	
	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if (dto.getId() != null) {
			// cap nhat
			entity = categoryRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto, CategoryEntity.class);
		entity = categoryRepository.save(entity);
		CategoryDTO result = mapper.map(entity, CategoryDTO.class);
		return result;
	}
	
	
	@Override
	public CategoryDTO findById(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).get();
		CategoryDTO dto = mapper.map(entity, CategoryDTO.class);
		return dto;
	}


}
