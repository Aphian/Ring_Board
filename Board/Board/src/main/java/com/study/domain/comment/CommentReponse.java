package com.study.domain.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentReponse {

    private Long id;                       
    private Long postId;                   
    private String content;                
    private String writer;                 
    private Boolean deleteYn;              
    private LocalDateTime createdDate;     
    private LocalDateTime modifiedDate;    

}