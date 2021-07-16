package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CategoryDTO;

public interface IcategoryService {
	List<CategoryDTO> findAll();
	void deleteCategory(long[] ids);
	CategoryDTO save(CategoryDTO dto);
	CategoryDTO findById(Long id);
}
