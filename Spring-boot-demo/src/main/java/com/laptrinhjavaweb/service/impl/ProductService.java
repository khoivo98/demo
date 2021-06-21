package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	private final ModelMapper mapper = new ModelMapper();

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		//lay id the loai
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity entity = new ProductEntity();
		if (dto.getId() != null) {
			//cap nhat
			entity =  productRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto,ProductEntity.class);
		entity.setCategory(category);
		entity = productRepository.save(entity);
		ProductDTO result = mapper.map(entity, ProductDTO.class); 
		return result;
	}

	@Override
	@Transactional
	public void deleteProduct(long[] ids) {
		for (long item : ids) {
			productRepository.deleteById(item);
		}
	}

	
	//phan trang
	@Override
	public List<ProductDTO> finAll(Pageable pageable) {
		List<ProductDTO> result = new ArrayList<>();
		Page<ProductEntity> entities = productRepository.findAll(pageable);
		for (ProductEntity item : entities) {
			result.add(mapper.map(item, ProductDTO.class));
		}
		return result;
	}
	
	
	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> result = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item : entities) {
			result.add(mapper.map(item, ProductDTO.class));
		}
		return result;
	}

	@Override
	public int totalItem() {
		return (int) productRepository.count();
	}

	

}