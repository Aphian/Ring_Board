package com.study.domain.file;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {
	
	private Long id;
	private Long postId;
	private String originalName;
	private String saveName;
	private long size;
	private Boolean deleteYn;
	private LocalDateTime createdDate;
	private LocalDateTime deletedDate;

}
