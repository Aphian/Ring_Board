package com.study.domain.member;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemberResponse {
	
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private Gender gender;
	private LocalDate birthday;
	private Boolean deleteYn;
	private LocalDateTime createdDate;
	private LocalDateTime modifyedDate;
	
	public void clearPassword() {
		this.password = "";
	}
	
}
