package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    // 사용자게에 메시지 전달
    private String showMessageAndRedirect(final MessageDto params, Model model) {
    	model.addAttribute("params", params);
    	return "common/messageRedirect";
    }

    // 게시글 작성 페이지
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

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        List<PostResponse> posts = postService.findAllPost(params);
        model.addAttribute("posts", posts);
        return "post/list";
    }


    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam(name = "id") final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/view";
    }


    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params, Model model) {
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }


    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params, Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }
    
    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam(name = "id") final Long id, Model model) {
    	postService.deletePost(id);
    	MessageDto message = new MessageDto("게시글 삭제", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }
    
}
