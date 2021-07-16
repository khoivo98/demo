package com.laptrinhjavaweb.dto;

import org.springframework.web.multipart.MultipartFile;

public class NewsDTO extends AbstractDTO<NewsDTO>{
	
	private String title;

	private MultipartFile thumbnail;

	private String shortDescription;
	
	private String content;
	
	private Long categoryId;
	
	private String categoryName;
	
	
	private UserDTO users;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}




	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public UserDTO getUsers() {
		return users;
	}


	public void setUsers(UserDTO users) {
		this.users = users;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public MultipartFile getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
}