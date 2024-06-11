package com.study.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {
	
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private Gender gender;
	private LocalDate birthday;
	
	public void encodingPassword(PasswordEncoder passwordEncoder) {
		if (StringUtils.isEmpty(password)) {
			return ;
		}
		password = passwordEncoder.encode(password);
	}

}
