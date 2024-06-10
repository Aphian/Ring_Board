package com.study.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	
	void save(CommentRequest params);
	
	CommentResponse findById(Long id);
	
	void update(CommentRequest params);
	
	void deleteById(Long id);
	
//	List<CommentResponse> findAll(Long postId);
	List<CommentResponse> findAll(CommentSearchDto params);
	
//	int count(Long postId);
	int count(CommentSearchDto params);

}
