package kr.green.maranix.dao;

import kr.green.maranix.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO member);

	MemberVO selectMember(String me_id);

	void updateMemberSession(MemberVO user);

	MemberVO selectBySession(String me_s_id);
}
