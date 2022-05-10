package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
