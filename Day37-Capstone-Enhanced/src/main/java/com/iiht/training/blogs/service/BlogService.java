package com.iiht.training.blogs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iiht.training.blogs.dto.BlogDto;

public interface BlogService {

	public BlogDto createBlog(BlogDto blogDto);

	public BlogDto getBlogById(Long id);

	public BlogDto updateBlog(Long id, BlogDto blogDto);

	public Boolean deleteBlog(Long id);
	
	// OPTIONALS
	public List<BlogDto> getAllBlogs();
	
	Page<BlogDto> searchBlogsByTitleCreated(String title, String created, Pageable pageable);
	
	Page<BlogDto> getAllBlogsPaged(Pageable pageable);
}
