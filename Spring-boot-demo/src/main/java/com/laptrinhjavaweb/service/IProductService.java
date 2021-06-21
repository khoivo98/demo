package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	ProductDTO save(ProductDTO dto);
	List<ProductDTO> finAll(Pageable pageable);
	List<ProductDTO> findAll();
	int totalItem();
	void deleteProduct(long[] ids);
}
