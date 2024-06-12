package com.study.domain.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {
	
	private Long id;
	private Long postId;
	private String originalName;
	private String saveName;
	private long size;
	
	@Builder
	public FileRequest(String originalName, String saveName, long size) {
		this.originalName = originalName;
		this.saveName = saveName;
		this.size = size;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}

}
