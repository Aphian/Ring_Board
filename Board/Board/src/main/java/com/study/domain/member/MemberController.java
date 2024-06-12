package com.study.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	// 로그인 페이지
    @GetMapping("/login.do")
    public String openLogin() {
        return "member/login";
    }
	
    // 회원 정보 저장
	@PostMapping("/members")
	@ResponseBody
	public Long saveMember(@RequestBody final MemberRequest params) {
		return memberService.saveMember(params);
	}
	
	// 회원 정보 조회
	@GetMapping("/members/{loginId}")
	@ResponseBody
	public MemberResponse findMemberByLoginId(@PathVariable(value = "loginId", required = false) final String loginId) {
		return memberService.findMemberByLoginId(loginId);
	}
	
	// 회원 정보 수정
	@PatchMapping("/members/{id}")
	@ResponseBody
	public Long updateMember(@PathVariable(value = "id", required = false) final Long id, @RequestBody final MemberRequest params) {
		return memberService.updateMember(params);
	}
	
	// 회원 탈퇴
	@DeleteMapping("/members/{id}")
	@ResponseBody
	public Long deleteMember(final Long id) {
		return memberService.deleteMemberById(id);
	}
	
	// ID 중복 체크
    @GetMapping("/member_count")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam(value = "loginId", required = false) final String loginId) {
        return memberService.countMemberByLoginId(loginId);
    }
	
	// 로그인
	@PostMapping("/login")
	@ResponseBody
	public MemberResponse login(HttpServletRequest request) {
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		MemberResponse member = memberService.login(loginId, password);
		
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60 * 30);
		}
		
		return member;
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.do";
	}
	
}
