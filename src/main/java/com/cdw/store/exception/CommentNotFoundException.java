package com.cdw.store.exception;

public class CommentNotFoundException extends RuntimeException{
	public CommentNotFoundException(String message) {
		super(message);
	}
}