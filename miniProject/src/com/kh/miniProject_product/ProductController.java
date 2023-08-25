package com.kh.miniProject_product;

import java.util.*;

class ProductController {
	  ArrayList<Product> products = new ArrayList<>();

	  public void add(String name, int price, int amount, String description) {
	    Product product = new Product(name, price, amount, description);
	    products.add(product);
	  }

	  public void modify(int index, String name, int price, int amount, String description) {
	    Product product = products.get(index);
	    product.name = name;
	    product.price = price;
	    product.amount = amount;
	    product.description = description;
	  }

	  public void remove(int index) {
	    products.remove(index);
	  }

	  public String printPro() {
	    String result = "";
	    for (Product product : products) {
	      result += (product.printProduct() + "\n");
	    }
	    return result;
	  }

	  public Product findByName(String name) {
	    for (Product product : products) {
	      if (product.name.equals(name)) {
	        return product;
	      }
	    }
	    return null;
	  }

	  public Product findByIndex(int index) {
	    return products.get(index);
	  }
	}
