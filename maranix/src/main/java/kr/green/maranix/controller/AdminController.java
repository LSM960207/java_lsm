package kr.green.maranix.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.request.Request;
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
import kr.green.maranix.vo.ProductOptionVO;
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
		cri.setPerPageNum(10);
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
		//messageService.message(response, "제품을 등록했습니다.", "/maranix/admin/product/list");
		mv.setViewName("redirect:/admin/product/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)
	public ModelAndView productDeletePost(ModelAndView mv, HttpServletResponse response, String pr_code) {
		boolean res = productService.deleteProduct(pr_code);
		if(res)
			messageService.message(response, "제품을 삭제했습니다.", "/maranix/admin/product/list");
		else
			messageService.message(response, "제품을 삭제하지 못했습니다.", "/maranix/admin/product/list");
		mv.setViewName("redirect:/admin/product/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/update", method = RequestMethod.GET)
	public ModelAndView productUpdateGet(ModelAndView mv, String pr_code) {
		ProductVO product = productService.selectProduct(pr_code);
		mv.addObject("pr", product);
		mv.setViewName("/admin/productUpdate");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/update", method = RequestMethod.POST)
	public ModelAndView productUpdatePost(ModelAndView mv, ProductVO product, MultipartFile file
			,HttpServletResponse response) {
		boolean res = productService.updateProduct(product, file);
		if(res) 
			messageService.message(response, "제품을 수정했습니다.", "/maranix/admin/product/list");
		else
			messageService.message(response, "제품을 수정하지 못했습니다.", "/maranix/admin/product/list");
		mv.setViewName("/admin/productUpdate");
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/size", method = RequestMethod.GET)
	public ModelAndView productSizeGet(ModelAndView mv) {
		ArrayList<ProductVO> productList = productService.selectProductList();
		ArrayList<ProductOptionVO> optionList = productService.selectOptionList();	
		mv.addObject("list", productList);
		mv.addObject("oList", optionList);
		mv.setViewName("/admin/productSize");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/delete", method = RequestMethod.POST)
	public ModelAndView optionDeletePost(ModelAndView mv, HttpServletResponse response, String po_num) {
		boolean res = productService.deleteOption(po_num);
		if(res)
			messageService.message(response, "제품을 삭제했습니다.", "/maranix/admin/product/size");
		else
			messageService.message(response, "제품을 삭제하지 못했습니다.", "/maranix/admin/product/size");
		mv.setViewName("redirect:/admin/product/size");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/insert", method = RequestMethod.GET)
	public ModelAndView optionInsertGet(ModelAndView mv) {
		ArrayList<ProductVO> productList = productService.selectProductList();
		mv.addObject("list", productList);
		mv.setViewName("/admin/optionInsert");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/insert", method = RequestMethod.POST)
	public ModelAndView optionInsertPost(ModelAndView mv,ProductOptionVO productOptionVO, HttpServletResponse response) {
		System.out.println(productOptionVO);
		productService.insertOption(productOptionVO);
		mv.setViewName("redirect:/admin/product/size");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/update", method = RequestMethod.GET)
	public ModelAndView optionUpdateGet(ModelAndView mv, String po_num) {
		ProductOptionVO product = productService.selectOption(po_num);
		mv.addObject("pr", product);
		mv.setViewName("/admin/productUpdate");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/update", method = RequestMethod.POST)
	public ModelAndView optionUpdatePost(ModelAndView mv, ProductVO product, MultipartFile file
			,HttpServletResponse response) {
		boolean res = productService.updateProduct(product, file);
		if(res) 
			messageService.message(response, "제품을 수정했습니다.", "/maranix/admin/product/list");
		else
			messageService.message(response, "제품을 수정하지 못했습니다.", "/maranix/admin/product/list");
		mv.setViewName("/admin/productUpdate");
		return mv;
	}
	
}