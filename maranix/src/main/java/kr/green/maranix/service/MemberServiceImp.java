package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.maranix.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
  MemberDAO memberDao;
	
	@Override
  public String getEmail(String id) {
      return memberDao.getEmail(id);
  }
}
