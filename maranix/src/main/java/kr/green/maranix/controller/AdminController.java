package kr.green.maranix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.pagination.PageMaker;
import kr.green.maranix.service.MessageService;
import kr.green.maranix.service.ProductService;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;
import kr.green.maranix.utils.StringUtils;


@Controller
public class AdminController {
	

	@Autowired
	ProductService productService;
	@Autowired
	MessageService messageService;
  
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
	
	@RequestMapping(value = "admin/product/select")
	public ModelAndView productSelect(ModelAndView mv, String pr_code,
			HttpSession session) {
		ProductVO product = productService.selectProduct(pr_code);
		ArrayList<ProductOptionVO> optionList = productService.selectAdminOptionList(pr_code);
		mv.addObject("oList", optionList);
		mv.addObject("p", product);
		mv.setViewName("/admin/productSelect");
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
	
	@RequestMapping(value = "/admin/option/info")
	public ModelAndView optionInsertGet(ModelAndView mv, HttpServletRequest request) {
		String po_num = StringUtils.nvl(request.getParameter("po_num"), "");
		 //"" == insert    "" != update po_num이 있으니까
		if(po_num == "") {
			ArrayList<ProductVO> prList = productService.selectProductList();
			List<ProductOptionVO> poList = productService.selectProductOption(po_num);
			mv.addObject("list", prList);
			mv.addObject("optionList", poList);
		}else {
			List<ProductOptionVO> poList = productService.selectProductOption(po_num);
			mv.addObject("po_num", po_num);
			System.out.println(poList);
			System.out.println(po_num);
			mv.addObject("optionList", poList);
		}
		mv.setViewName("/admin/optionPage");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/insert", method = RequestMethod.POST)
	public ModelAndView optionInsertPost(ModelAndView mv,ProductOptionVO productOption, HttpServletResponse response) {
		boolean res = productService.insertOption(productOption);
		if(res) 
			messageService.message(response, "제품옵션을 등록했습니다.", "/maranix/admin/product/size");
		else
			messageService.message(response, "제품옵션을 등록하지 못했습니다.", "/maranix/admin/product/size");
		mv.setViewName("redirect:/admin/product/size");
		return mv;
	}
	
	@RequestMapping(value = "/admin/option/update", method = RequestMethod.POST)
	public ModelAndView optionUpdatePost(ModelAndView mv, ProductOptionVO productOption, HttpServletResponse response) {
		boolean res = productService.updateOption(productOption);
		if(res) 
			messageService.message(response, "제품을 수정했습니다.", "/maranix/admin/product/size");
		else
			messageService.message(response, "제품을 수정하지 못했습니다.", "/maranix/admin/product/size");
		mv.setViewName("redirect:/admin/product/size");
		return mv;
	}

	
}