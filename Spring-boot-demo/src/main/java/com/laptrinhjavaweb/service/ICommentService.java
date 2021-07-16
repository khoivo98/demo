package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CommentDTO;

public interface ICommentService {
	List<CommentDTO> findAll();
	void deleteComment(long[] ids);
	CommentDTO save(CommentDTO dto);
	CommentDTO findById(Long id);
}
