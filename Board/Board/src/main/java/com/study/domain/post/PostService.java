package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.study.common.dto.SearchDto;
import com.study.common.paging.Pagination;
import com.study.common.paging.PagingResponse;

import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;

@Service
// 클래스 내에 final로 선언된 모든 멤버에 대한 생성자를 만들어줌.
@RequiredArgsConstructor
public class PostService {
	
	private final PostMapper postMapper;
	
	// 트랜잭션 처리 방법 중 하나
	// 선언적 트랜잭션으로 불리는 기능, 메서드의 실행과 동시에 트랜잭션이 시작되고, 메서드의 정상 종료 여부에 따라 Commit 또는 Rollback 을 해준다.
	@Transactional
	public Long savePost(final PostRequest param) {
		postMapper.save(param);
		return param.getId();
	}
	
	public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }
	
	@Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }
	
	public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }
	
//	public List<PostResponse> findAllPost(final SearchDto params) {
//        return postMapper.findAll(params);
//    }
	
	public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
		int count = postMapper.count(params);
		if (count < 1) {
			return new PagingResponse<>(Collections.emptyList(), null);
		}
		
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		List<PostResponse> list = postMapper.findAll(params);
		return new PagingResponse<>(list, pagination);
	}

}
