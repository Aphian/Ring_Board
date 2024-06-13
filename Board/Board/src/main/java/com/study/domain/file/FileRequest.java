package com.study.domain.file;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {
	
	private Long id;
	private Long postId;
	private String originalName;
	private String saveName;
	private long size;
	
	private List<Long> removeFileIds = new ArrayList<>();
	
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
