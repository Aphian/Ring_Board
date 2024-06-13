package com.study.domain.file;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FileService {
	
	private final FileMapper fileMapper;
	
	@Transactional
	public void saveFiles(final Long postId, final List<FileRequest> files) {
		
		if (CollectionUtils.isEmpty(files)) {
			return;
		}
		
		for (FileRequest file : files) {
			file.setPostId(postId);
		}
		
		fileMapper.saveAll(files);
		
	}
	
	public List<FileResponse> findAllFileByPostId(final Long postId) {
		return fileMapper.findAllByPostId(postId);
	}
	
	public List<FileResponse> findAllFileByIds(final List<Long> ids) {
		
		if (CollectionUtils.isEmpty(ids)) {
			return Collections.emptyList();
		}
		
		return fileMapper.findAllByIds(ids);
		
	}
	
	@Transactional
	public void deleteAllFileByIds(final List<Long> ids) {
		
		if (CollectionUtils.isEmpty(ids)) {
			return ;
		}
		fileMapper.deleteAllByIds(ids);
		
	}

}
