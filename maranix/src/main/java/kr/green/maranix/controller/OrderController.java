package kr.green.maranix.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.service.OrderService;
import kr.green.maranix.service.ProductService;
import kr.green.maranix.vo.MemberVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;


@Controller
public class OrderController {
	
	@Autowired
  OrderService orderService;
	@Autowired
	ProductService productService;
  
	@RequestMapping(value = "/order/form")
	public ModelAndView orderForm(ModelAndView mv, String pr_code, HttpSession session, HttpServletRequest request) {
		ProductVO product = productService.selectProduct(pr_code);
		ArrayList<ProductOptionVO> poList = productService.selectPrOptionList(pr_code);
		MemberVO user = (MemberVO)session.getAttribute("user");
		mv.addObject("price", request.getParameter("pr_price"));
		mv.addObject("amount", request.getParameter("od_amount"));
		mv.addObject("user", user);
		mv.addObject("p", product);
		mv.addObject("optionList", poList);
		mv.setViewName("/order/form");
		return mv;
	}
	
	@RequestMapping(value = "/order/insert", method = RequestMethod.POST)
	public ModelAndView orderInsert(ModelAndView mv) {
		mv.setViewName("/order/insert");
		return mv;
	}
}
