package com.cdw.store.service.impl;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.CommentDto;
import com.cdw.store.exception.ProductNotFoundException;
import com.cdw.store.exception.UserNotFoundException;
import com.cdw.store.model.Comment;
import com.cdw.store.model.Product;
import com.cdw.store.model.User;
import com.cdw.store.repo.CommentRepo;
import com.cdw.store.repo.ProductRepo;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.service.ICommentService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
public class CommentService implements ICommentService {
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public CommentDto addComment(CommentDto commentDto) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentDto, comment);
		comment.setCreatedDate(new Date());
		comment.setId(null);
		
		Product product = productRepo.findById(commentDto.getProductId())
				.orElseThrow(() -> new ProductNotFoundException("Product by id = " + commentDto.getProductId() + " was not found"));
		comment.setProductComment(product);

		if (commentDto.getUserId() != -1l) {
			User user = userRepo.findById(commentDto.getUserId()).orElseThrow(
					()-> new UserNotFoundException("User by id = " + commentDto.getUserId() + " was not found"));
					
			comment.setUserComment(user);
		}

		comment = commentRepo.save(comment);

		CommentDto result = new CommentDto();
		BeanUtils.copyProperties(comment, result);

		return result;
	}

	@Override
	public List<CommentDto> getAllCommentByProductId(Long id) {
		List<Comment> comments = commentRepo.findByProductCommentId(id);
		List<CommentDto> commentDtos = comments.stream().map((item)->{
			CommentDto dto = new CommentDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
		return commentDtos;
	}

	@Override
	public Page<CommentDto> getAllCommentByProductId(Long id, Integer page) {		
		Pageable nthPageWithFiveElements = PageRequest.of(page, 5, Sort.by("createdDate").descending());
		//Pageable nthPageWithFiveElements = PageRequest.of(page, 5);

		Page<Comment> comments = commentRepo.findByProductCommentId(id, nthPageWithFiveElements);
		Page<CommentDto> results = comments.map(new Function<Comment, CommentDto>() {
			@Override
			public CommentDto apply(Comment entity) {
				CommentDto dto = new CommentDto();
				BeanUtils.copyProperties(entity, dto);
				return dto;
			}			
		});
		return results;
	}

}
