package com.iiht.training.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.blogs.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	// By default, the query definition uses JPQL.
	// @Query("SELECT c FROM comments c")

	// We can use also native SQL to define our query
	// @Query(value = "SELECT c FROM comments c", nativeQuery = true)

	List<CommentEntity> findByBlogId(Long blogId);

}
