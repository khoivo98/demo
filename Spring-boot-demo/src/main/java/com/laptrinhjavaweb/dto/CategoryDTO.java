package com.laptrinhjavaweb.dto;

public class CategoryDTO extends AbstractDTO<CategoryDTO>{ 
	private String code;
	
	private String name;
	
	private String details; 
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}