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


@Controller
public class HomeController {
	
	@Autowired
  MemberService memberService;
  
  @RequestMapping(value="/")
  public ModelAndView main(ModelAndView mv) throws Exception{
  	
      mv.setViewName("/main/home");
      return mv;
  }

	
}
