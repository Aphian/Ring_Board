package com.study.interceptor;

import com.study.domain.member.MemberResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// 세션 회원 정보 조회
		HttpSession session = request.getSession();
		MemberResponse member = (MemberResponse) session.getAttribute("loginMember");
		
		// 회원 정보 체크
		if (member == null || member.getDeleteYn() == true) {
			response.sendRedirect("/login.do");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
		
		
	}

}
