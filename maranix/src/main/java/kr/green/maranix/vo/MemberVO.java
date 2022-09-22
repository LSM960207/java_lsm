package kr.green.maranix.vo;

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
}
