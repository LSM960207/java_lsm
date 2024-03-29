package kr.green.maranix.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.maranix.dao.ProductDAO;
import kr.green.maranix.pagination.Criteria;
import kr.green.maranix.utils.UploadFileUtils;
import kr.green.maranix.vo.CategoryVO;
import kr.green.maranix.vo.ProductOptionVO;
import kr.green.maranix.vo.ProductVO;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	String productThumbnailUploadPath = "D:\\git\\product";
	
	@Override
	public ArrayList<CategoryVO> getCategoryList() {
		return productDao.selectCategoryList();
	}
	
	@Override
	public int insertCategory(CategoryVO category) {
		if(category == null || 
				category.getCa_name()==null || 
				category.getCa_name().length() == 0 ||
				category.getCa_code() == null ||
				category.getCa_code().length() == 0)
			return -2;
		if(category.getCa_code().length() != 3)
			return 1;
		
		try {
			productDao.insertCategory(category);
		}catch(Exception e) {
			return -1;
		}
		return 0;
	}

	@Override
	public ArrayList<ProductVO> selectProductList(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return productDao.selectProductList(cri);
	}

	@Override
	public int getProductTotalCount(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return productDao.selectProductTotalCount(cri);
	}

	@Override
	public void insertProduct(ProductVO product, MultipartFile file) {
		if(product == null || file == null || file.getOriginalFilename().length() == 0)
			return;
		
		String prefix = product.getPr_ca_name();//COM001
		CategoryVO category = productDao.selectCategoryByCa_code(prefix.substring(0,3));
		try {
			product.setPr_ca_name(category.getCa_name());
			String dir = product.getPr_ca_name();//COM
			
			String str = UploadFileUtils.uploadFile(productThumbnailUploadPath,File.separator + dir, prefix, file.getOriginalFilename(), file.getBytes());
			product.setPr_thumb("/" +dir+ str);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		productDao.insertProduct(product);
		productDao.updateCategory(category);
	}

	@Override
	public boolean deleteProduct(String pr_code) {
		if(pr_code == null || pr_code.length() != 6)
			return false;
		ProductVO product= productDao.selectProduct(pr_code);
		if(product == null)
			return false;
		UploadFileUtils.deleteFile(productThumbnailUploadPath, product.getPr_thumb());
		return productDao.deleteProduct(pr_code) == 1 ? true : false;
	}

	@Override
	public ProductVO selectProduct(String pr_code) {
		if(pr_code == null || pr_code.length() != 6)
			return null;
		return productDao.selectProduct(pr_code);
	}

	@Override
	public boolean updateProduct(ProductVO product, MultipartFile file) {
		System.out.println(product);
		if(product == null)
			return false;
		
		ProductVO dbProduct = productDao.selectProduct(product.getPr_code());
		if(dbProduct == null)
			return false;
		if(file == null || file.getOriginalFilename().length() == 0) {
			product.setPr_thumb(dbProduct.getPr_thumb());
		}else {
			//기존 썸네일 서버에서 삭제
			UploadFileUtils.deleteFile(productThumbnailUploadPath, dbProduct.getPr_thumb());
			//새 썸네일 서버에 업로드 후 vo에 추가
			String prefix = product.getPr_code();
			try {
				String dir = product.getPr_ca_name();//COM
				String str = UploadFileUtils.uploadFile(productThumbnailUploadPath,File.separator + dir, prefix, file.getOriginalFilename(), file.getBytes());
				product.setPr_thumb("/" +dir+ str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productDao.updateProduct(product) == 1 ? true : false;
	}

	@Override
	public ArrayList<ProductVO> selectProductList() {
		return productDao.selectProductList2();
	}

	@Override
	public ArrayList<ProductOptionVO> selectOptionList() {
		return productDao.selectOptionList();
	}
	
	@Override
	public ArrayList<ProductOptionVO> selectAdminOptionList(String pr_code) {
		return productDao.selectAdminOptionList(pr_code);
	}
	
	@Override
	public boolean deleteOption(String po_num) {
		if(po_num == null)
			return false;
		ProductOptionVO product= productDao.selectOption(po_num);
		if(product == null)
			return false;
		return productDao.deleteOption(po_num) == 1 ? true : false;
	}
	
	@Override
	public ProductOptionVO selectOption(String po_num) {
		if(po_num == null)
			return null;
		
		return productDao.selectOption(po_num);
	}
	
	@Override
	public boolean insertOption(ProductOptionVO productOptionVO) {
		if(productOptionVO == null)
			return false;
		
	 return	productDao.insertOption(productOptionVO);
	}
	
	@Override
	public List<ProductOptionVO> selectProductOption(String po_num) {
		return productDao.selectProductOption(po_num);
	}

	@Override
	public boolean updateOption(ProductOptionVO productOption) {
		if(productOption == null)
			return false;
		
		return productDao.updateOption(productOption);
	}
	
	@Override
	public ArrayList<ProductVO> selectProductCaList(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return productDao.selectProductCaList(cri);
	}

	@Override
	public ArrayList<ProductOptionVO> selectPrOptionList(String pr_code) {
		return productDao.selectPrOptionList(pr_code);
	}
	
	@Override
	public ProductOptionVO selectPrOption(String po_num) {
		return productDao.selectPrOption(po_num);
	}	
}
