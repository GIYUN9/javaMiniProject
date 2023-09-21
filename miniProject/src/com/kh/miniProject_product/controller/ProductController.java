package com.kh.miniProject_product.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniProject_product.model.service.ProductService;
import com.kh.miniProject_product.model.vo.Product;
import com.kh.miniProject_product.view.ProductMenu;

public class ProductController {
	Scanner sc = new Scanner(System.in);
	public int indexNum = 0;
	public ArrayList<Product> products = new ArrayList<>();
	
	public void insertProduct(String pro_name, int pro_price, int pro_amount, String pro_description){
		Product p = new Product(pro_name, pro_price, pro_amount, pro_description);
	
		int result = new ProductService().insertProduct(p);
		
		if (result > 0) {
			new ProductMenu().displaySuccess("상품을 추가하였습니다.");
		} else {
			new ProductMenu().displayFail("상품추가에 실패하였습니다.");
		}
	}

	public void updateProduct(int pro_no,String pro_name, int pro_price, int pro_amount, String pro_description) {
		
		Product p = new Product();
		p.setPro_no(pro_no);
		p.setPro_name(pro_name);
		p.setPro_price(pro_price);
		p.setPro_amount(pro_amount);
		p.setPro_description(pro_description);
		
		int result = new ProductService().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("상품 정보 변경을 완료하였습니다.");
		} else {
			new ProductMenu().displayFail("상품 정보 변경에 실패했습니다.");
		}
	}
	
	public void delectProduct(int pro_no) {
		int result = new ProductService().delectProduct(pro_no);
		
		if (result > 0) {
			new ProductMenu().displaySuccess("상품번호 : "+ pro_no +"번의 삭제를 성공하였습니다.");
		} else {
			new ProductMenu().displayFail("상품삭제에 실패하였습니다.");
		}
	}
	
	public Product remove(int x) {
		Product product = products.remove(x);
		return product;
	}
	
	public String printPro() {
		String result = "인덱스번호\t상품명\t가격\t수량\t설명\n";
		for (Product product : products) {
			result += (indexNum+"\t"+product.toString() + "\n");
			indexNum++;
		}
		indexNum = 0;
		return result;
	}
}
