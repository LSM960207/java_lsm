package kr.green.maranix.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.service.MemberService;
import kr.green.maranix.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
  MemberService memberService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.addObject("title","회원가입");
		mv.setViewName("/main/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		boolean res = memberService.signup(member);
		if(res)
			mv.setViewName("redirect:/signup/success");
		else
			mv.setViewName("redirect:/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup/success", method = RequestMethod.GET)
	public ModelAndView signupSuccessGet(ModelAndView mv) {
		mv.addObject("title","회원가입완료");
		mv.setViewName("/main/signupSuccess");
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv, MemberVO member) {
		MemberVO user = memberService.login(member);
		mv.addObject("user", user);
		mv.addObject("title","로그인");
		if(user == null)
			mv.setViewName("/main/login");
		else
			mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) {
		memberService.logout(request,response);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, String type) {
		
		mv.addObject("type", type);
		mv.setViewName("/main/find");
		return mv;
	}
	
	@RequestMapping(value ="/find/id", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> findId(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		ArrayList<String> idList = memberService.getIdList(member);
		map.put("idList", idList);
		return map;
	}
	
	@RequestMapping(value ="/find/pw", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> findPw(@RequestBody MemberVO member){
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		boolean res = false;
		boolean exception = false;
		try {
			res = memberService.findPw(member);
		}catch(Exception e) {
			exception = true;
		}
		map.put("res", res);
		map.put("exception", exception);
		return map;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView userUpdateGet(ModelAndView mv) {
		mv.setViewName("/main/update");
		return mv;
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView userUpdatePost(ModelAndView mv,MemberVO member, 
			HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		memberService.updateMember(member,user);
		mv.setViewName("/main/update");
		return mv;
	}
}
