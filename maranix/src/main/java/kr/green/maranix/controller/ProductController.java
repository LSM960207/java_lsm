package kr.green.maranix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.service.ProductService;
import kr.green.maranix.vo.LikesVO;
import kr.green.maranix.vo.MemberVO;
import kr.green.maranix.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product/select", method = RequestMethod.GET)
	public ModelAndView productSelect(ModelAndView mv, String pr_code,
			HttpSession session) {
		ProductVO product = productService.selectProduct(pr_code);
		MemberVO user = (MemberVO)session.getAttribute("user");
		LikesVO likes = productService.getLikes(pr_code, user);
		mv.addObject("li", likes);
		mv.addObject("p", product);
		mv.setViewName("/product/select");
		return mv;
	}
	
}
