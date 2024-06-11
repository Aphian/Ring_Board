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


@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/login.do")
	public String openLogin() {
		return "member/login";
	}
	
	@PostMapping("/members")
	@ResponseBody
	public Long saveMember(@RequestBody final MemberRequest params) {
		return memberService.saveMember(params);
	}
	
	@GetMapping("/members/{loginId}")
	@ResponseBody
	public MemberResponse findMemberByLoginId(@PathVariable(value = "loginId", required = false) final String loginId) {
		return memberService.findMemberByLoginId(loginId);
	}
	
	@PatchMapping("/members/{id}")
	@ResponseBody
	public Long updateMember(@PathVariable(value = "id", required = false) final Long id, @RequestBody final MemberRequest params) {
		return memberService.updateMember(params);
	}
	
	@DeleteMapping("/members/{id}")
	@ResponseBody
	public Long deleteMember(final Long id) {
		return memberService.deleteMemberById(id);
	}
	
	@GetMapping("/member-count")
	@ResponseBody
	public int countMemberByLoginId(@RequestParam final String loginId) {
		return memberService.countMemberByLoginId(loginId);
	}
	
	

}
