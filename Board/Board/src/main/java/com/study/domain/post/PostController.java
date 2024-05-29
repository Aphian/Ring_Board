package com.study.domain.post;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
    	
        return "post/write";
    }
//    public String openPostWrite(Model model) {
//    	String title = "제목", content = "내용", write = "홍길동";
//    	
//    	model.addAttribute("t", title);
//    	model.addAttribute("c", content);
//    	model.addAttribute("w", write);
//    	
//    	return "post/write";
//    }
    
    // 게시글 저장
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/post/list.do";
    }
    
    // 게시글 목록 조회
    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
    	List<PostResponse> posts = postService.findAllPost();
    	model.addAttribute("posts", posts);
    	return "post/list";
    	
    }
    

}

