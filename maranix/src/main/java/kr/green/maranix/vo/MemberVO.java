package kr.green.maranix.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private int me_authority;
	private String me_name;
	private String me_phone;
	private String me_email;
	private String me_code;
	private String me_s_id;
	private Date me_s_limit;
	public boolean autoLogin;
	
}
