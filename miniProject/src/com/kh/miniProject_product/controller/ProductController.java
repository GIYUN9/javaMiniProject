package com.kh.miniProject_product.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniProject_product.model.service.ProductService;
import com.kh.miniProject_product.model.vo.Product;

public class ProductController {
	Scanner sc = new Scanner(System.in);
	public int indexNum = 0;
	public ArrayList<Product> products = new ArrayList<>();
	
	public void insertProduct(String pro_name, int pro_price, int pro_amount, String pro_description){
		Product p = new Product(pro_name, pro_price, pro_amount, pro_description);
	
		int result = new ProductService().insertProduct(p); //이것도 만들기 하나 수행하도록 넘어가면서 하나씩 기능완성하기
	}

	
	// 여기부터수정 jdbc사용하게끔
	public void modifyName(String name) {
		System.out.println("수정할 상품의 인덱스를 입력해주세요 : ");
		int index = sc.nextInt();
		
		Product product = products.get(index);
		product.setName(name);
	}

	public void modifyPrice(int price) {
		System.out.println("수정할 상품의 인덱스를 입력해주세요 : ");
		int index = sc.nextInt();
		
		Product product = products.get(index);
		product.setPrice(price);
	}

	public void modifyAmount(int amount) {
		System.out.println("수정할 상품의 인덱스를 입력해주세요 : ");
		int index = sc.nextInt();
		
		Product product = products.get(index);
		product.setAmount(amount);
	}

	public void modifyDescription(String description) {
		System.out.println("수정할 상품의 인덱스를 입력해주세요 : ");
		int index = sc.nextInt();
		
		Product product = products.get(index);
		product.setDescription(description);
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
