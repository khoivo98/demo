package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewsDTO;
import com.laptrinhjavaweb.service.INewsService;
@RestController
public class NewsAPI {
	@Autowired
	private INewsService newsService;
	
	
	@PostMapping(value = "/api/news")
	   public NewsDTO createNews(@RequestBody NewsDTO model) {
	      return newsService.save(model);
	}
	
	
	@PutMapping(value = "/api/news")
	   public NewsDTO updateNews(@RequestBody NewsDTO model) {
	      return newsService.save(model);
	}
	
	@DeleteMapping(value = "/api/news")
	   void deleteNews(@RequestBody long[] ids) {
		newsService.deleteNews(ids);
	}
}
