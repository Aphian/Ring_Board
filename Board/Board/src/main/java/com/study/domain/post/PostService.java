package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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
	
	public List<PostResponse> findAllPost() {
        return postMapper.findAll();
    }
	
	public MessageDto(String message, String redirectUri, RequestMethod method, Map<String, Object> data) {
		this.message = message;
		this.redirectUri = redirectUri;
		this.method = method;
        this.data = data;
        
	}

}
