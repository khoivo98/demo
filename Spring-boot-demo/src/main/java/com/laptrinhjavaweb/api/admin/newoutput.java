package com.laptrinhjavaweb.api.admin;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.ProductDTO;

public class newoutput {
	private int page;
	private int totalPage;
	private List<ProductDTO> ListResult = new ArrayList<>();
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<ProductDTO> getListResult() {
		return ListResult;
	}
	public void setListResult(List<ProductDTO> listResult) {
		ListResult = listResult;
	}

}
