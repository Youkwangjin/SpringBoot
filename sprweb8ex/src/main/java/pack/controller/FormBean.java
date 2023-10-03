package pack.controller;

import lombok.Data;

@Data
public class FormBean {
	private String jikwon_no, jikwon_name, buser_num, jikwon_jik, jikwon_pay, jikwon_gen;
	private String buser_no, buser_name, buser_loc, buser_tel;
	private String searchValue;

}
