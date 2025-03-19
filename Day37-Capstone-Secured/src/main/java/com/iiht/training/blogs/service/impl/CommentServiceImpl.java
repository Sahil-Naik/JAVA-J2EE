package com.iiht.training.blogs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.blogs.dto.CommentDto;
import com.iiht.training.blogs.entity.CommentEntity;
import com.iiht.training.blogs.exceptions.BlogNotFoundException;
import com.iiht.training.blogs.repository.BlogRepository;
import com.iiht.training.blogs.repository.CommentRepository;
import com.iiht.training.blogs.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto postComment(CommentDto commentDto) {
        // Check if the Blog ID exists
        if (!blogRepository.existsById(commentDto.getBlogId())) {
            throw new BlogNotFoundException("Blog not found with ID: " + commentDto.getBlogId());
        }

        // Convert DTO to Entity
        CommentEntity commentEntity = modelMapper.map(commentDto, CommentEntity.class);

        // Save Comment to Database
        commentEntity = commentRepository.save(commentEntity);

        // Convert back to DTO and return
        return modelMapper.map(commentEntity, CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentsByBlogId(Long blogId) {
        // Check if Blog exists
        if (!blogRepository.existsById(blogId)) {
            throw new BlogNotFoundException("Blog not found with ID: " + blogId);
        }

        // Fetch Comments
        List<CommentEntity> comments = commentRepository.findByBlogId(blogId);

        // Convert Entities to DTOs
        return comments.stream()
                .map(commentEntity -> modelMapper.map(commentEntity, CommentDto.class))
                .collect(Collectors.toList());
    }
}