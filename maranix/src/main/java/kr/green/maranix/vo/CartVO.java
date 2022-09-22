package kr.green.maranix.vo;

import lombok.Data;

@Data
public class CartVO {
	private int ca_num;
	private String ca_me_id;
	private int ca_count;
	private String ca_po_name;
}
