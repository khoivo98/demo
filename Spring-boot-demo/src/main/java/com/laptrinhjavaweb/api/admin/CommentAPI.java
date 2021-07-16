package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.service.ICommentService;
@RestController
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	
	@PostMapping(value = "/api/comment")
	   public CommentDTO createComment(@RequestBody CommentDTO model) {
	      return commentService.save(model);
	}
	
	
	@PutMapping(value = "/api/comment")
	   public CommentDTO updateComment(@RequestBody CommentDTO model) {
	      return commentService.save(model);
	}
	
	@DeleteMapping(value = "/api/comment")
	   void deleteComment(@RequestBody long[] ids) {
		commentService.deleteComment(ids);
	}
}
