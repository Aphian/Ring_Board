package com.study.domain.comment;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommentApiController {
	
	private final CommentService commentService;
	
	@PostMapping("/posts/{postId}/comments")
	public CommentReponse saveCommnet(@PathVariable final Long postId, @RequestBody final CommentRequest params) {
		Long id = commentService.saveComment(params);
		return commentService.findCommentById(id);
	}
	
	
	@GetMapping("/posts/{postId}/comments")
	public List<CommentReponse> findAllComment(@PathVariable final Long postId) {
		return commentService.findAllComment(postId);
	}
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public CommentReponse findCommentById(@PathVariable final Long postId, @PathVariable final Long id) {
		return commentService.findCommentById(id);
	}
	
	
	@PostMapping("/posts/{postId}/comments/{id}")
	public CommentReponse updateComment(@PathVariable final Long postId, @PathVariable final Long id, @RequestBody final CommentRequest params) {
		commentService.updateComment(params);
		return commentService.findCommentById(id);
	}
	
	

}
