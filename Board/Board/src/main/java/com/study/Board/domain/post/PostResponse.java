package com.study.Board.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private long id;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private Boolean noticeYn;
    private Boolean deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime noticeDate;

}
