package kr.green.maranix.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private String or_num;
	private String or_me_id;
	private Date or_date;
	private String or_request;
	private String or_price;
	private String or_pname;
	private String or_tel;
	private String or_post;
	private String or_addr1;
	private String or_addr2;
	private String or_email;

	public String getOr_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(or_date);
	}
}
