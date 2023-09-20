package com.kh.miniProject_product.model.vo;

public class Product {
	//필드
	private int pro_no;
	private String pro_name;
	private int pro_price;
	private int pro_amount;
	private String pro_description;

	//생성자
	public Product() {
		
	}
	
	public Product(String pro_name, int pro_price, int pro_amount, String pro_description) {
		super();
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_amount = pro_amount;
		this.pro_description = pro_description;
	}

	public Product(int pro_no, String pro_name, int pro_price, int pro_amount, String pro_description) {
		super();
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_amount = pro_amount;
		this.pro_description = pro_description;
	}
	
	// getter/setter
	public int getPro_no() {
		return pro_no;
	}
	
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	
	public String getPro_name() {
		return pro_name;
	}
	
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	public int getPro_price() {
		return pro_price;
	}
	
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	
	public int getPro_amount() {
		return pro_amount;
	}
	
	public void setPro_amount(int pro_amount) {
		this.pro_amount = pro_amount;
	}
	
	public String getPro_description() {
		return pro_description;
	}
	
	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	@Override
	public String toString() {
		return pro_no + pro_name + pro_price + pro_amount + pro_description;
	}
	
	public String pro_header() {
		String header = "상품번호\t상품명\t가격\t수량\t상품설명";
		return header;
	}
	
}
