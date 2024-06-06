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
	
	public CommentReponse saveCommnet(@PathVariable final Long postId, @RequestBody final CommentRequest params) {
		Long id = commentService.saveComment(params);
		return commentService.findCommentById(id);
	}
	
	
	@GetMapping("/post/{postId}/comments")
	public List<CommentReponse> findAllComment(@PathVariable final Long postId) {
		return commentService.findAllComment(postId);
	}

}
