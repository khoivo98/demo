package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.NewsDTO;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.repository.NewsRepository;
import com.laptrinhjavaweb.service.INewsService;
@Service
public class NewsService implements INewsService{

	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private NewsRepository newsRepository;
	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> result = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll();
		for (NewsEntity item : entities) {
			result.add(mapper.map(item, NewsDTO.class));
		}
		return result;
	}
	@Override
	public void deleteNews(long[] ids) {
		for (long item : ids) {
			newsRepository.deleteById(item);
		}
	}
	
	
	@Override
	public NewsDTO save(NewsDTO dto) {
		NewsEntity entity = new NewsEntity();
		if (dto.getId() != null) {
			// cap nhat
			entity = newsRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto, NewsEntity.class);
		entity = newsRepository.save(entity);
		NewsDTO result = mapper.map(entity, NewsDTO.class);
		return result;
	}
	
	
	@Override
	public NewsDTO findById(Long id) {
		NewsEntity entity = newsRepository.findById(id).get();
		NewsDTO dto = mapper.map(entity, NewsDTO.class);
		return dto;
	}

}
