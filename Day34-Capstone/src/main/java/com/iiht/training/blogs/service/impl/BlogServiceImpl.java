package com.iiht.training.blogs.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.blogs.dto.BlogDto;
import com.iiht.training.blogs.entity.BlogEntity;
import com.iiht.training.blogs.exceptions.BlogNotFoundException;
import com.iiht.training.blogs.repository.BlogRepository;
import com.iiht.training.blogs.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public BlogDto createBlog(BlogDto blogDto) {
		// Convert DTO to Entity
		BlogEntity blogEntity = mapToEntity(blogDto);
		// Save to DB
		blogEntity = blogRepository.save(blogEntity);
		// Convert back to DTO and return
		return mapToDto(blogEntity);
	}

	@Override
	public BlogDto getBlogById(Long id) {
		// Find Blog by ID
		BlogEntity blogEntity = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
		// Convert to DTO and return
		return mapToDto(blogEntity);
	}

	@Override
	public BlogDto updateBlog(Long id, BlogDto blogDto) {
		// Find Blog by ID
		BlogEntity existingBlog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		// Update Fields
		existingBlog.setTitle(blogDto.getTitle());
		existingBlog.setContent(blogDto.getContent());

		// Save Updated Entity
		existingBlog = blogRepository.save(existingBlog);

		// Convert to DTO and return
		return mapToDto(existingBlog);
	}

	@Override
	public Boolean deleteBlog(Long id) {
		// Check if Blog Exists
		Optional<BlogEntity> blogEntity = blogRepository.findById(id);
		if (blogEntity.isPresent()) {
			// Delete Blog
			blogRepository.deleteById(id);
			return true;			
		}
		throw new BlogNotFoundException("Blog not found with ID: " + id);		
	}

	// Helper Methods for Conversion
	private BlogDto mapToDto(BlogEntity blogEntity) {
		BlogDto dto = new BlogDto();
		dto.setId(blogEntity.getId());
		dto.setTitle(blogEntity.getTitle());
		dto.setContent(blogEntity.getContent());
		return dto;
	}

	private BlogEntity mapToEntity(BlogDto blogDto) {
		BlogEntity entity = new BlogEntity();
		entity.setTitle(blogDto.getTitle());
		entity.setContent(blogDto.getContent());
		return entity;
	}
}
