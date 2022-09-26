package kr.green.maranix.dao;

import java.util.ArrayList;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.ProductVO;

public interface ProductDAO {

	ArrayList<CategoryVO> selectCategoryList();

	void insertCategory(CategoryVO category);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int selectProductTotalCount(Criteria cri);

	CategoryVO selectCategoryByCa_code(String substring);

	void insertProduct(ProductVO product);

	void updateCategory(CategoryVO category);

}
