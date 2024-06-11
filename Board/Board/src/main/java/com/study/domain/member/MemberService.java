package com.study.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입
	@Transactional
	public Long saveMember(final MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		memberMapper.save(params);
		return params.getId();
		
	}
	
	// 가입정보 조회
	public MemberResponse findMemberByLoginId(final String LoginId) {
		return memberMapper.findByLoginId(LoginId);
	}
	
	// 회원 내용 수정
	@Transactional
	public Long updateMember(final MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		memberMapper.update(params);
		return params.getId();
	}
	
	// 회원탈퇴
	@Transactional
	public Long deleteMemberById(final Long id) {
		memberMapper.deleteById(id);
		return id;
	}
	
	// 회원 수 카운팅
	public int countMemberByLoginId(final String loginId) {
		return memberMapper.countByLoginId(loginId);
	}
	
	// 로그인
	public MemberResponse login(final String loginId, final String password) {
		
		MemberResponse member = findMemberByLoginId(loginId);
		String encodedPassword = (member == null) ? "" : member.getPassword();
		
		if (member == null || passwordEncoder.matches(password, encodedPassword)) {
			return null;
		}
		
		member.clearPassword();
		return member;
		
	}

}
