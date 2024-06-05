package com.study.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    @Transactional
    public Long saveComment(final CommentRequest params) {
        commentMapper.save(params);
        return params.getId();
    }

    public CommentReponse findCommentById(final Long id) {
        return commentMapper.findById(id);
    }

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     * @return PK
     */
    @Transactional
    public Long updateComment(final CommentRequest params) {
        commentMapper.update(params);
        return params.getId();
    }

    @Transactional
    public Long deleteComment(final Long id) {
        commentMapper.deleteById(id);
        return id;
    }

    public List<CommentReponse> findAllComment(final Long postId) {
        return commentMapper.findAll(postId);
    }

}