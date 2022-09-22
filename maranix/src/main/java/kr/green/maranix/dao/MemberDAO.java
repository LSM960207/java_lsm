package kr.green.maranix.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.maranix.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO member);
}
