package com.iiht.training.blogs.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.iiht.training.blogs.dto.CommentDto;

public interface CommentService {

	public CommentDto postComment(CommentDto commentDto);
	
	// By default, the query definition uses JPQL.
	//@Query("SELECT c FROM comments c")
	
	// We can use also native SQL to define our query
	//@Query(value = "SELECT c FROM comments c",  nativeQuery = true)
	List<CommentDto> getCommentsByBlogId(Long blogId);

}
