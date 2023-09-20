package com.kh.miniProject_product.model.service;

import java.sql.Connection;

import com.kh.miniProject_product.common.JDBCTemplate;
import com.kh.miniProject_product.model.vo.Product;

public class ProductService {
	
	public int insertProduct(Product p) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().insertProduct(conn, m);
	}

}
