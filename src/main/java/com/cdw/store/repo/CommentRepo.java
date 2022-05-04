package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
