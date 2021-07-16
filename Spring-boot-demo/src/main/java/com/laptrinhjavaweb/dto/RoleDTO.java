package com.laptrinhjavaweb.dto;

public class RoleDTO extends AbstractDTO<RoleDTO>{
	
	private String name;
	
	public RoleDTO() {
		
	}



	@Override
	public String toString() {
		return this.name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}