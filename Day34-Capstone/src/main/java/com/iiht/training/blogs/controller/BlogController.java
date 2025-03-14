package com.iiht.training.blogs.controller;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.blogs.dto.BlogDto;
import com.iiht.training.blogs.dto.CommentDto;
import com.iiht.training.blogs.exceptions.BlogNotFoundException;
import com.iiht.training.blogs.service.BlogService;
import com.iiht.training.blogs.service.CommentService;

@RestController
@RequestMapping("/api/blogs")
@Validated
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CommentService commentService;

	// Create a Blog
	@PostMapping
	public ResponseEntity<BlogDto> createBlog(@Valid @RequestBody BlogDto blogDto) {
		BlogDto createdBlog = blogService.createBlog(blogDto);
		return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
	}

	// Get Blog by ID
	@GetMapping("/{id}")
	public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id) {
		BlogDto blogDto = blogService.getBlogById(id);
		return new ResponseEntity<>(blogDto, HttpStatus.OK);
	}

	// Update Blog by ID
	@PutMapping("/{id}")
	public ResponseEntity<BlogDto> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDto blogDto) {
		BlogDto updatedBlog = blogService.updateBlog(id, blogDto);
		return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
	}

	// Delete Blog by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
		boolean isDeleted = blogService.deleteBlog(id);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}

	// Post a Comment on a Blog
	@PostMapping("/comment")
	public ResponseEntity<CommentDto> postComment(@Valid @RequestBody CommentDto commentDto) {
		CommentDto postedComment = commentService.postComment(commentDto);
		return new ResponseEntity<>(postedComment, HttpStatus.OK);
	}

	// Exception Handler for Blog Not Found
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<String> handleBlogNotFoundException(BlogNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}

