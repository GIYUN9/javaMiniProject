package com.kh.miniProject_product.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniProject_product.model.service.ProductService;
import com.kh.miniProject_product.model.vo.Product;
import com.kh.miniProject_product.model.vo.Trading;
import com.kh.miniProject_product.view.ProductMenu;

public class ProductController {
	Scanner sc = new Scanner(System.in);
	public int indexNum = 0;
	public ArrayList<Product> products = new ArrayList<>();
		
	public String printPro() {
		String result = "인덱스번호\t상품명\t가격\t수량\t설명\n";
		for (Product product : products) {
			result += (indexNum+"\t"+product.toString() + "\n");
			indexNum++;
		}
		indexNum = 0;
		return result;
	}
	
	
//	================================고객
	/**
	 * 고객의 전체 상품 조회
	 */
	public void selectList() {
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("상품 조회 결과가 없습니다.");
		} else {
			new ProductMenu().displayProductList(list);
		}
	}
	
	/**
	 * 고객의 상품 검색 (상품명으로 검색)
	 */
	public void selectByProName(String pro_name) {
		ArrayList<Product> list = new ProductService().selectByProName(pro_name);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData(pro_name + " 상품은 존재하지 않습니다.");
		} else {
			new ProductMenu().displayProductList(list);
		}
	}
	
	/**
	 * 고객의 상품 구매
	 */
	public void updateBuyTrading(int cus_no, int pro_no, int tra_amount) {
		Trading t = new Trading(cus_no, pro_no, tra_amount);
		
		int result = new ProductService().insertTrading(t);
		
		if (result > 0) {
			new ProductMenu().displaySuccess("상품 구매 완료");
		} else {
			new ProductMenu().displayFail("상품 구매 실패");
		}
	}
	
	/**
	 * 고객의 거래이력 조회
	 */
	public void selectTrading(int cus_no) {
		ArrayList<Trading> list = new ProductService().tradingList(cus_no);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("회원님의 거래내역이 없습니다.");
		} else {
			new ProductMenu().displayTradingList(list);
		}
	}
	
//	================================관리자
	
	/**
	 * 관리자의 상품 추가
	 */
	public void insertProduct(String pro_name, int pro_price, int pro_amount, String pro_description){
		Product p = new Product(pro_name, pro_price, pro_amount, pro_description);
	
		int result = new ProductService().insertProduct(p);
		
		if (result > 0) {
			new ProductMenu().displaySuccess("상품을 추가하였습니다.");
		} else {
			new ProductMenu().displayFail("상품추가에 실패하였습니다.");
		}
	}
	
	/**
	 * 관리자의 상품 수정
	 */
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
	
	/**
	 * 관리자의 상품 삭제
	 */
	public void delectProduct(int pro_no) {
		int result = new ProductService().delectProduct(pro_no);
		
		if (result > 0) {
			new ProductMenu().displaySuccess("상품번호 : "+ pro_no +"번의 삭제를 성공하였습니다.");
		} else {
			new ProductMenu().displayFail("상품삭제에 실패하였습니다.");
		}
	}
}
