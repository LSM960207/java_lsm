package kr.green.maranix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.LikesVO;
import kr.green.maranix.vo.MemberVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;

public interface ProductService {

	ArrayList<CategoryVO> getCategoryList();

	int insertCategory(CategoryVO category);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int getProductTotalCount(Criteria cri);

	void insertProduct(ProductVO product, MultipartFile file);

	boolean deleteProduct(String pr_code);

	ProductVO selectProduct(String pr_code);

	boolean updateProduct(ProductVO product, MultipartFile file);

	LikesVO getLikes(String pr_code, MemberVO user);

	ArrayList<ProductVO> selectProductListByLikes(MemberVO user);

	int updateLikes(LikesVO likes);
	
	ArrayList<ProductVO> selectProductList();
	
	ArrayList<ProductOptionVO> selectOptionList();
	
	boolean deleteOption(String po_num);
	
	ProductOptionVO selectOption(String po_num);
	
	boolean insertOption(ProductOptionVO productOptionVO);
	
	List<ProductOptionVO> selectProductOption(String po_num);

	boolean updateOption(ProductOptionVO productOption);
}
