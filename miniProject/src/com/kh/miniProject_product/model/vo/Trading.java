package com.kh.miniProject_product.model.vo;

import java.sql.Date;

public class Trading {
	private int tra_no;
	private int cus_no;
	private int pro_no;
	private int tra_amount;
	private String tra_method;
	private Date tra_date;
	
	public Trading() {
		
	}

	public Trading(int tra_no, int cus_no, int pro_no, int tra_amount,String tra_method, Date tra_date) {
		super();
		this.tra_no = tra_no;
		this.cus_no = cus_no;
		this.pro_no = pro_no;
		this.tra_amount = tra_amount;
		this.tra_method = tra_method;
		this.tra_date = tra_date;
	}
	
	public Trading(int cus_no, int pro_no ,int tra_amount) {
		super();
		this.cus_no = cus_no;
		this.pro_no = pro_no;
		this.tra_amount = tra_amount;
	}

	public int getTra_no() {
		return tra_no;
	}

	public void setTra_no(int tra_no) {
		this.tra_no = tra_no;
	}

	public int getCus_no() {
		return cus_no;
	}

	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public int gettra_amount() {
		return tra_amount;
	}

	public void settra_amount(int tra_amount) {
		this.tra_amount = tra_amount;
	}

	public String getTra_method() {
		return tra_method;
	}

	public void setTra_method(String tra_method) {
		this.tra_method = tra_method;
	}

	public Date getTra_date() {
		return tra_date;
	}

	public void setTra_date(Date tra_date) {
		this.tra_date = tra_date;
	}

	@Override
	public String toString() {
		return tra_no + "\t" + cus_no + "\t" + pro_no + "\t"+ tra_amount +"\t" + tra_method + "\t" + tra_date;
	}
	
	public String tra_header() {
		String header = "거래번호\t고객번호\t상품번호\t수량\t거래방식\t거래일자";
		return header;
	}
}
