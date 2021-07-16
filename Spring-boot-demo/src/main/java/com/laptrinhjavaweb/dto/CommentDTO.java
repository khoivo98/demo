package com.laptrinhjavaweb.dto;

import javax.validation.constraints.NotNull;

public class CommentDTO extends AbstractDTO<CommentDTO>{
	@NotNull
	private String content;

	private Long newsId;
	
	private String newsTitle;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}


	
}