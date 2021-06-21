package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {
	
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		dto.setNote(entity.getNote());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	
	
	
	
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		entity.setNote(dto.getNote());
		return entity;
	}
	
	
	
	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		entity.setNote(dto.getNote());
		return entity;
	}
}
