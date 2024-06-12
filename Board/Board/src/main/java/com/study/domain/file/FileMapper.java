package com.study.domain.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
	
	void saveAll(List<FileRequest> files);

}
