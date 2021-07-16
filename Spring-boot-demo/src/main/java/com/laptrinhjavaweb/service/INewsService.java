package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.NewsDTO;

public interface INewsService {
	List<NewsDTO> findAll();
	void deleteNews(long[] ids);
	NewsDTO save(NewsDTO dto);
	NewsDTO findById(Long id);
}
