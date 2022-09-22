package kr.green.maranix.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class ComplainVO {
	private int cp_num;
	private String cp_me_id;
	private int cp_od_num;
	private String cp_name;
	private String cp_content;
	private Date cp_date;
	private String cp_ct_type;
	
	public String getCp_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cp_date);
	}
}
