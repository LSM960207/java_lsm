package kr.green.maranix.service;

import java.util.ArrayList;

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

	ArrayList<String> getIdList(MemberVO member);

	boolean findPw(MemberVO member);

	void sendEmail(String title, String content, String email);
	
	void updateMember(MemberVO member, MemberVO user);
}
