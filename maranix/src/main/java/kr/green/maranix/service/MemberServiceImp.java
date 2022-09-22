package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.maranix.dao.MemberDAO;
import kr.green.maranix.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
  MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	private String createRandom(String str, int count) {
		if(str == null)
			return "";
		String randomStr = "";
		
		for(int i = 0; i<count; i++) {
			int r = (int)(Math.random()*str.length());
			randomStr += str.charAt(r);
		}
		return randomStr;
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String me_code = createRandom(str, 6);
		member.setMe_code(me_code);
		String newPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(newPw);
		try {
			memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
