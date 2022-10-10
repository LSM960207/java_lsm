package kr.green.maranix.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
	private int od_num;
	private int od_amount;
	private int od_price;
	private String od_state;
	private int od_or_num;
	private int od_po_num;
}
