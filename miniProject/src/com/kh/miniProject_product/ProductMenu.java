package com.kh.miniProject_product;

import java.util.Scanner;

public class ProductMenu {
	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	private static final String ADMIN_ID = "2"; 
	private static final String ADMIN_PSW = "2"; 
	String adLoginId;
	String adLoginPsw;
	
	public void CustomerMenu() {
		System.out.println("=======고객 메뉴=======");
		System.out.println("1. 전체 상품 목록 조회");
		System.out.println("2. 상품 조회");
		System.out.println("3. 상품 구매");
		System.out.println("4. 뒤로가기(메인 메뉴)");
		int pmNum = sc.nextInt();
		
		switch(pmNum) {
			case 1:
				System.out.println("상품명\t가격\t수량\t설명");
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				
		}
	}
}
