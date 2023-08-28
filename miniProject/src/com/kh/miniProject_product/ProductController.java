package com.kh.miniProject_product;

import java.util.*;

public class ProductController {
	Scanner sc = new Scanner(System.in);
	public int indexNum = 0;
	ArrayList<Product> products = new ArrayList<>();
	
	public void add(String name, int price, int amount, String description){
		Product product = new Product(name, price, amount, description);
		products.add(product);
	}

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
			result += (indexNum+"\t"+product.printProduct() + "\n");
			indexNum++;
		}
		indexNum = 0;
		return result;
	}
}
