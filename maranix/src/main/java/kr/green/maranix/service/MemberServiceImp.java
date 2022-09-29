package kr.green.maranix.service;

import java.util.ArrayList;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@Autowired
	JavaMailSender mailSender;
	
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
		
		user.setAutoLogin(member.isAutoLogin());
		
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
		Cookie cookie = WebUtils.getCookie(request, "mmCookie");
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

	@Override
	public ArrayList<String> getIdList(MemberVO member) {
		if(member== null)
			return null;
		return memberDao.selectIdList(member);
	}

	@Override
	public void sendEmail(String title, String content, String email) {
		String setfrom = "lsm960207@naver.com";         
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper messageHelper 
          = new MimeMessageHelper(message, true, "UTF-8");

      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
      messageHelper.setTo(email);     // 받는사람 이메일
      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
      messageHelper.setText(content,true);  // 메일 내용

      mailSender.send(message);
    } catch(Exception e){
        System.out.println(e);
    }

	}
	
	@Override
	public boolean findPw(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_name() == null || member.getMe_email() == null) {
			return false;
		}
		
		MemberVO dbMember = memberDao.selectMemberByIdNameEmail(member);
		
		if(dbMember == null) {
			return false;
		}
		
		//임시 비번 발급 - 랜덤으로 8자리, 영문(대소문자 다 가능)(26,26), 숫자(10)만 가능
		String newPw = "";
		int max = 8;
		for(int i = 0; i<max; i++) {
			int r = (int)(Math.random()*62);
			//r : 0~9 => 숫자, 10~35 => 소문자, 36~61 => 대문자
			if(r <= 9)
				newPw += r;
			else if(r <= 35)
				newPw += (char)('a' + r - 10);
			else 
				newPw += (char)('a' + r - 36);
		}
		/*
		String charaters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<max; i++) {
			int r = (int)(Math.random()*62);
			newPw += charaters.charAt(r);
		}
		*/
		//임시 비번을 등록된 이메일로 전송
		String title = "새 비밀번호입니다.";
		String content = "임시 비밀번호를 발급했습니다. 임시 비밀번호는 <b>"+newPw+"</b>입니다.";
		sendEmail(title, content, member.getMe_email());
		
		//새 비번을 회원 정보에 저장(암호화해서)
		String encPw = passwordEncoder.encode(newPw);
		dbMember.setMe_pw(encPw);
		memberDao.updateMember(dbMember);
		
		return true;
	}

	@Override
	public void updateMember(MemberVO member, MemberVO user) {
		if(member == null || user == null || member.getMe_id() == null)
			return;
		//화면에서 보낸 아이디와 로그인한 아이디가 다르면 회원정보 수정을 안함
		if(!member.getMe_id().equals(user.getMe_id()))
			return;
		
		user.setMe_name(member.getMe_name());
		user.setMe_phone(member.getMe_phone());
		user.setMe_email(member.getMe_email());
		
		if(member.getMe_authority() != 0)
			user.setMe_authority(member.getMe_authority());
		//비밀번호가 있으면 암호화하여 저장
		if(member.getMe_pw() != null && member.getMe_pw().length() != 0) {
			String encPw = passwordEncoder.encode(member.getMe_pw());
			user.setMe_pw(encPw);
		}
		memberDao.updateMember(user);
	}

}
