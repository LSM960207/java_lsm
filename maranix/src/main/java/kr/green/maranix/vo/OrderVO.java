package kr.green.maranix.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private int or_num;
	private String or_me_id;
	private Date or_date;
	private String or_state;
	private String or_request;
	private int or_ad_num;
	private int or_price;
	
	public String getOr_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(or_date);
	}
}
