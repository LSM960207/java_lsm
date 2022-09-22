package kr.green.maranix.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class PaymentVO {
	private int pa_num;
	private int pa_or_num;
	private Date pa_time;
	private Date pa_succ;
	private String pa_state;
	
	public String getPa_time_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(pa_time);
	}
	public String getPa_succ_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(pa_succ);
	}
}
