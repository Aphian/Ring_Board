package com.study.domain.post;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

import java.util.List;

@Mapper
public interface PostMapper {
    // 게시글 저장
	
    void save(PostRequest params);
    
    // 상세 조회
    PostResponse findById(Long id);

    // 게시글 수정
    void update(PostRequest params);

    // 게시글 삭제
    void deleteById(Long id);

    // 리스트 조회
    List<PostResponse> findAll(SearchDto params);

    int count(SearchDto params);
}
