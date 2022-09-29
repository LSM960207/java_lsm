package kr.green.maranix.dao;

import java.util.ArrayList;

import kr.green.maranix.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO member);

	MemberVO selectMember(String me_id);

	void updateMemberSession(MemberVO user);

	MemberVO selectBySession(String me_s_id);

	ArrayList<String> selectIdList(MemberVO member);

	MemberVO selectMemberByIdNameEmail(MemberVO member);

	void updateMember(MemberVO dbMember);
}
