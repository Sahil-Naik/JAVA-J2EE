package com.iiht.training.blogs.service;

import java.util.List;

import com.iiht.training.blogs.dto.CommentDto;

public interface CommentService {

	public CommentDto postComment(CommentDto commentDto);
	
	
	List<CommentDto> getCommentsByBlogId(Long blogId);

}
