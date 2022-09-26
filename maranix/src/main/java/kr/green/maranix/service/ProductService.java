package kr.green.maranix.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.ProductVO;

public interface ProductService {

	ArrayList<CategoryVO> getCategoryList();

	int insertCategory(CategoryVO category);

	ArrayList<ProductVO> selectProductList(Criteria cri);

	int getProductTotalCount(Criteria cri);

	void insertProduct(ProductVO product, MultipartFile file);

}
