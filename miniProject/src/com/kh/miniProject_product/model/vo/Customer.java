package com.kh.miniProject_product.model.vo;

import java.sql.Date;

public class Customer {
	private int cus_no;
	private String cus_id;
	private String cus_pwd;
	private String nickName;
	private Date enrolldate;
	
	public Customer() {
		
	}

	public Customer(int cus_no, String cus_id, String cus_pwd, String nickName, Date enrolldate) {
		super();
		this.cus_no = cus_no;
		this.cus_id = cus_id;
		this.cus_pwd = cus_pwd;
		this.nickName = nickName;
		this.enrolldate = enrolldate;
	}

	public int getCus_no() {
		return cus_no;
	}

	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_pwd() {
		return cus_pwd;
	}

	public void setCus_pwd(String cus_pwd) {
		this.cus_pwd = cus_pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return cus_no + cus_id + cus_pwd + nickName + enrolldate;
	}
	
	public String cus_header() {
		String header = "고객번호\t고객ID\t고객PWD\t닉네임\t가입일자";
		return header;
	}
	
	
	
	
}
