package kr.green.maranix.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.pagination.PageMaker;
import kr.green.maranix.service.ProductService;
import kr.green.maranix.vo.CategoryVO;
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
	
	@RequestMapping(value = "/list/capList", method = RequestMethod.GET)
	public ModelAndView productCapList(ModelAndView mv,Criteria cri) {
	  cri.setPr_ca_name("CAP");
		ArrayList<ProductVO> list = productService.selectProductCaList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/list/capList");
		return mv;
	}
	
	@RequestMapping(value = "/list/clothList", method = RequestMethod.GET)
	public ModelAndView productClothList(ModelAndView mv,Criteria cri) {
		cri.setPr_ca_name("CLOTH");
		ArrayList<ProductVO> list = productService.selectProductCaList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/list/clothList");
		return mv;
	}
	
	@RequestMapping(value = "/list/spgList", method = RequestMethod.GET)
	public ModelAndView productSpgList(ModelAndView mv, Criteria cri) {
		cri.setPr_ca_name("SPG");
   	ArrayList<ProductVO> list = productService.selectProductCaList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/list/spgList");
		return mv;
	}
	
	@RequestMapping(value = "/likes/list", method = RequestMethod.GET)
	public ModelAndView likesList(ModelAndView mv, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<ProductVO> list = productService.selectProductListByLikes(user);
		mv.addObject("list", list);
		mv.setViewName("/product/likesList");
		return mv;
	}
	
	@RequestMapping(value="/category/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> categoryList() {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		ArrayList<CategoryVO> list = productService.getCategoryList();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="/ajax/product/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> ajaxProductList(@RequestBody Criteria cri) {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		ArrayList<ProductVO> list = productService.selectProductList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="/likes", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> likes(@RequestBody LikesVO likes) {
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		int res = productService.updateLikes(likes);
		map.put("res", res);
		return map;
	}
	
}