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
	
	@Transactional
	public Long saveMember(final MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		memberMapper.save(params);
		return params.getId();
		
	}
	
	public MemberResponse findMemberByLoginId(final String LoginId) {
		return memberMapper.findByLoginId(LoginId);
	}
	
	@Transactional
	public Long updateMember(final MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		memberMapper.update(params);
		return params.getId();
	}
	
	@Transactional
	public Long deleteMemberById(final Long id) {
		memberMapper.deleteById(id);
		return id;
	}
	
	public int countMemberByLoginId(final String loginId) {
		return memberMapper.countByLoginId(loginId);
	}

}
