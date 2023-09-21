package com.kh.miniProject_product.model.service;

import java.sql.Connection;

import com.kh.miniProject_product.common.JDBCTemplate;
import com.kh.miniProject_product.model.dao.MiniDao;
import com.kh.miniProject_product.model.vo.Product;

public class ProductService {
	
	public int insertProduct(Product p) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().insertProduct(conn, p);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int delectProduct(int pro_no) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().delectProduct(conn, pro_no);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updateProduct(Product p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().updateProduct(conn, p);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

}
