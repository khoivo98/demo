package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.service.ICommentService;
@Service
public class CommentService implements ICommentService{

	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> result = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll();
		for (CommentEntity item : entities) {
			result.add(mapper.map(item, CommentDTO.class));
		}
		return result;
	}
	@Override
	public void deleteComment(long[] ids) {
		for (long item : ids) {
			commentRepository.deleteById(item);
		}
	}
	
	
	@Override
	public CommentDTO save(CommentDTO dto) {
		CommentEntity entity = new CommentEntity();
		if (dto.getId() != null) {
			// cap nhat
			entity = commentRepository.findById(dto.getId()).get();
		}
		entity = mapper.map(dto, CommentEntity.class);
		entity = commentRepository.save(entity);
		CommentDTO result = mapper.map(entity, CommentDTO.class);
		return result;
	}
	
	
	@Override
	public CommentDTO findById(Long id) {
		CommentEntity entity = commentRepository.findById(id).get();
		CommentDTO dto = mapper.map(entity, CommentDTO.class);
		return dto;
	}

	
}
