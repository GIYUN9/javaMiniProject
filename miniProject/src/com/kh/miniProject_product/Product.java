package com.kh.miniProject_product;

class Product {
	  String name;
	  int price;
	  int amount;
	  String description;

	  public Product() {
	  }

	  public Product(String name, int price, int amount, String description) {
	    this.name = name;
	    this.price = price;
	    this.amount = amount;
	    this.description = description;
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String printProduct() {
		return this.name+"\t"+this.price+"\t"+this.amount+"\t"+this.description;
	}

	}
