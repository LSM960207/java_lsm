package kr.green.maranix.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.service.OrdersService;
import kr.green.maranix.service.ProductService;
import kr.green.maranix.service.MemberService;
import kr.green.maranix.vo.MemberVO;
import kr.green.maranix.vo.OrderDetailVO;
import kr.green.maranix.vo.OrdersVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;


@Controller
public class OrdersController {
	
	@Autowired
  OrdersService ordersService;
	@Autowired
	ProductService productService;
	@Autowired
	MemberService memberService;
  
	@RequestMapping(value = "/orders/form")
	public ModelAndView orderForm(ModelAndView mv, String pr_code, HttpSession session, HttpServletRequest request) {
		ProductVO product = productService.selectProduct(pr_code);
		ArrayList<ProductOptionVO> poList = productService.selectPrOptionList(pr_code);
		MemberVO user = (MemberVO)session.getAttribute("user");
		mv.addObject("price", request.getParameter("pr_price"));
		mv.addObject("amount", request.getParameter("od_amount"));
		mv.addObject("user", user);
		mv.addObject("p", product);
		mv.addObject("optionList", poList);
		mv.setViewName("/orders/form");
		return mv;
	}
	/*
	 * @RequestMapping(value = "/order/insert", method = RequestMethod.GET) public
	 * ModelAndView orderInsertGet(ModelAndView mv, HttpSession session,
	 * OrderDetailVO odVO, OrderVO oVO, HttpServletRequest request ) {
	 * 
	 * mv.setViewName("/order/result"); return mv; }
	 */
	
	@RequestMapping(value = "/orders/insert", method = RequestMethod.POST)
	public ModelAndView orderInsertPost(ModelAndView mv, HttpSession session, OrderDetailVO odVO, OrdersVO oVO, HttpServletRequest request ) {
		String po_num = request.getParameter("od_po_num"); //Product
		String od_amount = request.getParameter("od_amount");//OrderDetail
		String od_price = request.getParameter("od_price");//OrderDetail
		String or_addr1 = request.getParameter("or_addr1"); //주소, Order
		String sample6_extraAddress = request.getParameter("sample6_extraAddress"); //참고항목, Order
		String totalAddr = or_addr1 + sample6_extraAddress; //주소+참고항목, Order
		String total = request.getParameter("total"); //총금액, Order
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		oVO.setOr_me_id(user.getMe_id());
		oVO.setOr_addr1(totalAddr);
		oVO.setOr_price(total);
		ordersService.insertOrders(oVO);
		
		odVO.setOd_amount(od_amount);
		odVO.setOd_price(od_price);
		ordersService.insertOrderDetail(odVO);
		
		ProductOptionVO product = productService.selectPrOption(po_num);
		
		OrdersVO orNum = new OrdersVO();
		orNum.setOr_num(orNum.getOr_num());
		OrdersVO orders = ordersService.selectOrders(orNum);
		
		OrderDetailVO odNum = new OrderDetailVO();
		odNum.setOd_num(odNum.getOd_num());
		OrderDetailVO od = ordersService.selectOrderDetail(odNum);
		
		mv.addObject("p", product);
		mv.addObject("or", orders);
		mv.addObject("od", od);
		mv.setViewName("/orders/result");
		return mv;
	}
}
