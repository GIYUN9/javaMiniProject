package com.kh.miniProject_product;

import java.util.*;

public class ProductController {
	ArrayList<Product> products = new ArrayList<>();
	
	public void add(String name, int price, int amount, String description){
		Product product = new Product(name, price, amount, description);
		products.add(product);
	}

	public void modifyName(String name) {
		for (Product product : products) {
			product.setName(name);
		}
	}

	public void modifyPrice(int price) {
		for (Product product : products) {
			product.setPrice(price);
		}
	}

	public void modifyAmount(int amount) {
		for (Product product : products) { 
			product.setAmount(amount);
		}
	}

	public void modifyDescription(String description) {
		for (Product product : products) { 
			product.setDescription(description); 
		}
	}
	
	public Product remove() {
		Product product = products.remove(0);
		return product;
	}
	
	public String printPro() {
		String result = "";
		for (Product product : products) {
			result += (product.printProduct() + "\n");
		}
		return result;
	}
}
