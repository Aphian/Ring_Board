package com.study.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	
	void save(CommentRequest params);
	
	CommentReponse findById(Long id);
	
	void update(CommentRequest params);
	
	void deleteById(Long id);
	
	List<CommentReponse> findAll(Long postId);
	
	int count(Long postId);

}
