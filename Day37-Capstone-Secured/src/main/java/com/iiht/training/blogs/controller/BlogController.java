package com.iiht.training.blogs.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.blogs.dto.BlogDto;
import com.iiht.training.blogs.dto.CommentDto;
import com.iiht.training.blogs.exceptions.BlogNotFoundException;
import com.iiht.training.blogs.service.BlogService;
import com.iiht.training.blogs.service.CommentService;

@RestController
@RequestMapping("/auth")
@Validated
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CommentService commentService;

	// Fetch all Blogs
	@GetMapping("/allblogs")
	public List<BlogDto> getAllBlogs() {
		return blogService.getAllBlogs();
	}

	// Create a Blog
	@PostMapping({"/user/blogs", "/admin/blogs"})
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<BlogDto> createBlog(@Valid @RequestBody BlogDto blogDto) {
		BlogDto createdBlog = blogService.createBlog(blogDto);
		return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
	}

	// Get Blog by ID
	@GetMapping({"/user/blogs/{id}", "/admin/blogs/{id}", "/viewer/blogs/{id}"})
	@PreAuthorize("hasRole('VIEWER') or hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id) {
		BlogDto blogDto = blogService.getBlogById(id);
		return new ResponseEntity<>(blogDto, HttpStatus.OK);
	}

	// Update Blog by ID
	@PutMapping({"/user/blogs/{id}"})
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<BlogDto> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDto blogDto) {
		BlogDto updatedBlog = blogService.updateBlog(id, blogDto);
		return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
	}

	// Delete Blog by ID
	@DeleteMapping({"/user/blogs/{id}", "/admin/blogs/{id}"})
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
		boolean isDeleted = blogService.deleteBlog(id);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}

	// Post a Comment on a Blog
	@PostMapping({"/user/blogs/comment", "/admin/blogs/comment"})
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<CommentDto> postComment(@Valid @RequestBody CommentDto commentDto) {
		CommentDto postedComment = commentService.postComment(commentDto);
		return new ResponseEntity<>(postedComment, HttpStatus.OK);
	}

	// Exception Handler for Blog Not Found
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<String> handleBlogNotFoundException(BlogNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@GetMapping({"/user/blogs/comment/{id}", "/admin/blogs/comment/{id}", "/viewer/blogs/comment/{id}"})
	@PreAuthorize("hasRole('VIEWER') or hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Map<String, Object>> getBlogWithComments(@PathVariable Long id) {
		// Retrieve Blog
		BlogDto blogDto = blogService.getBlogById(id);

		// Retrieve Comments
		List<CommentDto> comments = commentService.getCommentsByBlogId(id);

		// Prepare Response
		Map<String, Object> response = new HashMap<>();
		response.put("blog", blogDto);

		if (comments.isEmpty()) {
			response.put("comments", "There are no comments on this blog");
		} else {
			response.put("comments", comments);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Fetch all Blogs with pagination and search
	// @SuppressWarnings("null")
	@GetMapping({"/user/blogs/paged", "/admin/blogs/paged", "/viewer/blogs/paged"})
	@PreAuthorize("hasRole('VIEWER') or hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Page<BlogDto>> getAllBlogsPaged(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String created,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<BlogDto> blogPage;
		blogPage = blogService.getAllBlogsPaged(pageable); // You may need to implement this method

		return new ResponseEntity<>(blogPage, HttpStatus.OK);
	}

	@GetMapping({"/user/blogs/search", "/admin/blogs/search", "/viewer/blogs/search"})
	@PreAuthorize("hasRole('VIEWER') or hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Page<BlogDto>> searchBlogs(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String created,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<BlogDto> blogPage;

		blogPage = blogService.searchBlogsByTitleCreated(title, created, pageable);
		return ResponseEntity.ok(blogPage);
	}

}
