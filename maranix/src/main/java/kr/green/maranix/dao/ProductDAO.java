package kr.green.maranix.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.LikesVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;

public interface ProductDAO {

	ArrayList<CategoryVO> selectCategoryList();

	void insertCategory(CategoryVO category);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int selectProductTotalCount(Criteria cri);

	CategoryVO selectCategoryByCa_code(String substring);

	void insertProduct(ProductVO product);

	void updateCategory(CategoryVO category);

	ProductVO selectProduct(String pr_code);

	int deleteProduct(String pr_code);

	int updateProduct(ProductVO product);

	LikesVO selectLikes(@Param("pr_code")String pr_code, @Param("me_email")String me_email);

	ArrayList<ProductVO> selectProductListByLikes(String me_id);

	void insertLikes(LikesVO likes);

	void deleteLikes(LikesVO likes);

	ArrayList<ProductVO> selectProductList2();
	
	ArrayList<ProductOptionVO> selectOptionList();
	
	int deleteOption(String po_num);
	
	ProductOptionVO selectOption(String po_num);
	
	void insertOption(ProductOptionVO productOptionVO);
}
