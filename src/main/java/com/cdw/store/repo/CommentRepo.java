package com.cdw.store.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.dto.CommentDto;
import com.cdw.store.model.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

	List<Comment> findByProductCommentId(Long id);

	Page<Comment> findByProductCommentId(Long id, Pageable nthPageWithFiveElements);

}
