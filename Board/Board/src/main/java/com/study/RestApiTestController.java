package com.study;

import com.study.common.dto.SearchDto;
import com.study.common.paging.PagingResponse;
import com.study.domain.post.PostResponse;
import com.study.domain.post.PostService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiTestController {

    private final PostService postService;

    @GetMapping("/posts")
    public PagingResponse<PostResponse> findAllPost() {
        return postService.findAllPost(new SearchDto());
    }

}

//@Controller
//public class RestApiTestController {
//
//    @GetMapping("/members")
//    @ResponseBody
//    public List<Map<String, Object>> findAllMember() {
//
//        List<Map<String, Object>> members = new ArrayList<>();
//
//        for (int i = 1; i <= 20; i++) {
//            Map<String, Object> member = new HashMap<>();
//            member.put("id", i);
//            member.put("name", i + "번 개발자");
//            member.put("age", 10 + i);
//            members.add(member);
//        }
//
//        return members;
//    }
//
//}