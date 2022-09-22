package kr.green.maranix.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String pr_code;
	private String pr_thumb;
	private String pr_title;
	private String pr_content;
	private int pr_price;
	private int pr_count;
	private String pr_ca_name;
}
