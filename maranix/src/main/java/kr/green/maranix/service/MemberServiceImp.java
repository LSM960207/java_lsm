package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.maranix.dao.MemberDAO;
import kr.green.maranix.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
  MemberDAO memberDao;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		
		return false;
	}
}
