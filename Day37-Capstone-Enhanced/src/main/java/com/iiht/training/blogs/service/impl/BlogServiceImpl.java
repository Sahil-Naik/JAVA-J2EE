package com.iiht.training.blogs.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.iiht.training.blogs.dto.BlogDto;
import com.iiht.training.blogs.entity.BlogEntity;
import com.iiht.training.blogs.exceptions.*;
import com.iiht.training.blogs.repository.BlogRepository;
import com.iiht.training.blogs.service.BlogService;

import jakarta.transaction.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BlogDto> getAllBlogs() {
        List<BlogEntity> blogEntities = blogRepository.findAll();
        
        // Convert List<BlogEntity> to List<BlogDto>
        return blogEntities.stream()
                .map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        try {
            // Convert DTO to Entity
            BlogEntity blogEntity = modelMapper.map(blogDto, BlogEntity.class);
            // Save to DB
            blogEntity = blogRepository.save(blogEntity);
            // Convert back to DTO and return
            return modelMapper.map(blogEntity, BlogDto.class);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error saving blog: " + ex.getMessage());
        }
    }

    @Override
    public BlogDto getBlogById(Long id) {
        // Find Blog by ID
        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
        // Convert to DTO and return
        return modelMapper.map(blogEntity, BlogDto.class);
    }

    @Transactional
    @Override
    public BlogDto updateBlog(Long id, BlogDto blogDto) {
        // Find Blog by ID
        BlogEntity existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

        if (blogDto.getTitle() == null || blogDto.getTitle().isBlank()) {
            throw new InvalidRequestException("Title cannot be empty");
        }
        if (blogDto.getContent() == null || blogDto.getContent().isBlank()) {
            throw new InvalidRequestException("Content cannot be empty");
        }
        // Update Fields
        existingBlog.setTitle(blogDto.getTitle());
        existingBlog.setContent(blogDto.getContent());

        try {
            // Save Updated Entity
            existingBlog = blogRepository.save(existingBlog);
            // Convert to DTO and return
            return modelMapper.map(existingBlog, BlogDto.class);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error updating blog: " + ex.getMessage());
        }
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
    
    @Override
    public Page<BlogDto> searchBlogsByTitleCreated(String title, String created, Pageable pageable) {
        Page<BlogEntity> blogPage = blogRepository.findByTitleContainingIgnoreCaseOrCreatedContainingIgnoreCase(title, created, pageable);
        return blogPage.map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class));
    }
    
    @Override
    public Page<BlogDto> getAllBlogsPaged(Pageable pageable) {
        Page<BlogEntity> blogPage = blogRepository.findAll(pageable);
        return blogPage.map(blogEntity -> modelMapper.map(blogEntity, BlogDto.class));
    }
}