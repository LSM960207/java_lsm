package kr.green.maranix.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.pagination.PageMaker;
import kr.green.maranix.service.BoardService;
import kr.green.maranix.service.MessageService;
import kr.green.maranix.service.ProductService;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.ProductVO;


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
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public ModelAndView category(ModelAndView mv) {
		ArrayList<CategoryVO> list = productService.getCategoryList();
		mv.addObject("list",list);
		mv.setViewName("/admin/category");
		return mv;
	}
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public ModelAndView categoryPost(ModelAndView mv, CategoryVO category,
			HttpServletResponse response) throws IOException {
		int res = productService.insertCategory(category);
		
		messageService.categoryMessage(response, res);
		
		mv.setViewName("redirect:/admin/category");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView productListGet(ModelAndView mv, Criteria cri) {
		cri.setPerPageNum(2);
		ArrayList<ProductVO> list = productService.selectProductList(cri);
		int totalCount = productService.getProductTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		ArrayList<CategoryVO> categoryList = productService.getCategoryList();
		mv.addObject("cl", categoryList);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.setViewName("/admin/productList");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/insert", method = RequestMethod.GET)
	public ModelAndView productInsertGet(ModelAndView mv) {
		ArrayList<CategoryVO> cartegoryList = productService.getCategoryList();
		mv.addObject("list", cartegoryList);
		mv.setViewName("/admin/productInsert");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/insert", method = RequestMethod.POST)
	public ModelAndView productInsertPost(ModelAndView mv, ProductVO product, MultipartFile file,
			HttpServletResponse response) {
		productService.insertProduct(product, file);
		messageService.message(response, "제품을 등록했습니다.", "/lg/admin/product/list");
		mv.setViewName("redirect:/admin/product/list");
		return mv;
	}
}