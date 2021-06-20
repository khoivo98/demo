package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;
@Service

public class ProductService implements IProductService{

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private ProductConverter productConverter;
	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		if (productDTO.getId() != null) {
			ProductEntity oldProductEntity = productRepository.findById(productDTO.getId()).get();
			productEntity = productConverter.toEntity(productDTO, oldProductEntity);
		} else {
			productEntity = productConverter.toEntity(productDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(productDTO.getCategoryCode());
		productEntity.setCategory(categoryEntity);
		productEntity = productRepository.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public void deleteProduct(long[] ids) {
		for(long item:ids) {
			productRepository.deleteById(item);
		}
	}


	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> result = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for(ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.toDTO(item);
			result.add(productDTO);
		}
		return result;
	}

	@Override
	public int totalItem() {
		return (int) productRepository.count();
	}

	@Override
	public List<ProductDTO> finAll(Pageable pageable) {
		List<ProductDTO> result = new ArrayList<>();
		Page<ProductEntity> entities = productRepository.findAll(pageable);
		for(ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.toDTO(item);
			result.add(productDTO);
		}
		return result;
	}

}
