package kr.green.maranix.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.vo.CategoryVO;
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

	ArrayList<ProductVO> selectProductListByLikes(String me_id);

	ArrayList<ProductVO> selectProductList2();
	
	ArrayList<ProductOptionVO> selectOptionList();
	
	int deleteOption(String po_num);
	
	ProductOptionVO selectOption(String po_num);
	
	boolean insertOption(ProductOptionVO productOptionVO);
	
	List<ProductOptionVO> selectProductOption(String po_num);

	boolean updateOption(ProductOptionVO productOption);
	
	ArrayList<ProductVO> selectProductCaList(Criteria cri);

	ArrayList<ProductOptionVO> selectPrOptionList(String pr_code);
	
	ArrayList<ProductOptionVO> selectAdminOptionList(String pr_code);
	
	ProductOptionVO selectPrOption(String po_num);
}
