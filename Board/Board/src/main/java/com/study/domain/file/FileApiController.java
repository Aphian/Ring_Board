package com.study.domain.file;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileApiController {
	
	private final FileService fileService;
	
	@GetMapping("/posts/{postId}/files")
	public List<FileResponse> findAllFileByPostId(@PathVariable(value = "postId", required = false) final Long postId) {
		
		return fileService.findAllFileByPostId(postId);
		
	}

}
