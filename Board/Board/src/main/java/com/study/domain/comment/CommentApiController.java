package com.study.domain.comment;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommentApiController {
	
	private final CommentService commentService;
	
	@PostMapping("/posts/{postId}/comments")
	public CommentResponse saveComment(@PathVariable(value = "postId", required = false) final Long postId, @RequestBody final CommentRequest params) {
		Long id = commentService.saveComment(params);
		return commentService.findCommentById(id);
	}
	
	
	@GetMapping("/posts/{postId}/comments")
	public List<CommentResponse> findAllComment(@PathVariable(value = "postId", required = false) final Long postId) {
		return commentService.findAllComment(postId);
	}
	
	@GetMapping("/posts/{postId}/comments/{id}")
	public CommentResponse findCommentById(@PathVariable(value = "postId", required = false) final Long postId, @PathVariable(value = "id", required = false) final Long id) {
		return commentService.findCommentById(id);
	}
	
	
	@PatchMapping("/posts/{postId}/comments/{id}")
	public CommentResponse updateComment(@PathVariable(value = "postId", required = false) final Long postId, @PathVariable(value = "id", required = false) final Long id, @RequestBody final CommentRequest params) {
		commentService.updateComment(params);
		return commentService.findCommentById(id);
	}
	
	@DeleteMapping("/posts/{postId}/comments/{id}")
    public Long deleteComment(@PathVariable(value = "postId", required = false) final Long postId, @PathVariable(value = "id", required = false) final Long id) {
        return commentService.deleteComment(id);
    }
	
}
