package kr.green.maranix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.green.maranix.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);
	
	boolean isUser(MemberVO member);

	MemberVO login(MemberVO member);
	
	void updateMemberSession(MemberVO user);

	MemberVO loginBySession(String me_s_id);

	void logout(HttpServletRequest request, HttpServletResponse response);
}
