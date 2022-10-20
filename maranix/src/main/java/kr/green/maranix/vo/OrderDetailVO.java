package kr.green.maranix.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
	private int od_num;
	private String od_amount;
	private String od_price;
	private String od_or_num;
	private int od_po_num;
	private int or_num;
}
