package kr.green.maranix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.service.BoardService;
import kr.green.maranix.service.MessageService;
import kr.green.maranix.service.ProductService;


@Controller
public class AdminController {
	
	@Autowired
	ProductService productService;
	@Autowired
	MessageService messageService;
	@Autowired
	BoardService boardService;
  
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/admin/home");
		return mv;
	}
	
}
