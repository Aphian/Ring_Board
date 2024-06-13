package com.study.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PostRequest {

    private Long id;             
    private String title;        
    private String content;     
    private String writer;       
    private Boolean noticeYn;
    
    private List<MultipartFile> files = new ArrayList<>();
    private List<Long> removeFileIds = new ArrayList<>();

}
