package kr.green.maranix.vo;

import lombok.Data;

@Data
public class ProductOptionVO {
	private int po_num;
	private String po_pr_code;
	private int po_count;
	private String po_name;
	
	//따로 추가
	private String pr_title;
}
