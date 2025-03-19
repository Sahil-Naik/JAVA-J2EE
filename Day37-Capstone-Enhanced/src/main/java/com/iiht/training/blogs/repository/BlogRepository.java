package com.iiht.training.blogs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.blogs.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
	Page<BlogEntity> findByTitleContainingIgnoreCaseOrCreatedContainingIgnoreCase(String title, String created, Pageable pageable);

}
