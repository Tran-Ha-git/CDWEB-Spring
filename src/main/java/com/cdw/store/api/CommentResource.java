package com.cdw.store.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.CommentDto;
import com.cdw.store.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentResource {
	@Autowired
	private ICommentService commentService;

	@PostMapping("/add")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
		CommentDto result = commentService.addComment(commentDto);
		return new ResponseEntity<CommentDto>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/all/product-{id}")
	public ResponseEntity<List<CommentDto>> getAllCommentByProductId(@PathVariable Long id) {
		List<CommentDto> comments = commentService.getAllCommentByProductId(id);
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
	}
	
//	@GetMapping("/all/product-{id}")
//	public ResponseEntity<List<CommentDto>> getAllCommentByProductId(@PathVariable Long id, @RequestParam int page) {
//		List<CommentDto> comments = commentService.getAllCommentByProductId(id);
//		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
//	}
	
	@GetMapping("/all/product-{id}/p")
	public ResponseEntity<Page<CommentDto>> getAllCommentByProductId(@PathVariable Long id, @RequestParam(required = false) Integer page) {
		if(page == null) {
			page = 0;
		}
		Page<CommentDto> comments = commentService.getAllCommentByProductId(id, page);
		return new ResponseEntity<Page<CommentDto>>(comments, HttpStatus.OK);
	}
}
