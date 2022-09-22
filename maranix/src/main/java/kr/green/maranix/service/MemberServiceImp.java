package kr.green.maranix.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

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

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null)
			return null;
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null)
			return null;
		
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

	@Override
	public boolean isUser(MemberVO member) {
		if(member == null || member.getMe_email() == null)
			return false;
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null)
			return false;
		return true;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		if(request == null)
			return;
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null)
			return ;
		session.removeAttribute("user");
		Cookie cookie = WebUtils.getCookie(request, "lgCookie");
		if(cookie == null || response == null)
			return;
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		user.setMe_s_id(null);
		user.setMe_s_limit(null);
		memberDao.updateMemberSession(user);
	}

	@Override
	public void updateMemberSession(MemberVO user) {
		if(user == null || user.getMe_id() == null)
			return;
		memberDao.updateMemberSession(user);
	}

	@Override
	public MemberVO loginBySession(String me_s_id) {
		if(me_s_id == null)
			return null;
		return memberDao.selectBySession(me_s_id);
	}

}
