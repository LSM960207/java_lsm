package kr.green.maranix.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
