package com.kh.miniProject_product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.miniProject_product.common.JDBCTemplate;
import com.kh.miniProject_product.model.dao.MiniDao;
import com.kh.miniProject_product.model.vo.Customer;
import com.kh.miniProject_product.model.vo.Product;
import com.kh.miniProject_product.model.vo.Trading;

public class ProductService {
//	---------------------------고객
	public ArrayList<Product> selectList(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new MiniDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Trading> tradingList(int cus_no) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Trading> list = new MiniDao().tradingList(conn, cus_no);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Product> selectByProName(String pro_name) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new MiniDao().selectByProName(conn, pro_name);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int insertTrading(Trading t){
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().insertTrading(conn, t);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int insertCustomer(Customer c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MiniDao().insertCustomer(conn, c);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
//	------------------------관리자
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
	
	public ArrayList<Customer> selectCustomerList(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Customer> list = new MiniDao().selectCustomerList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Trading> selectTradingList(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Trading> list = new MiniDao().selectTradingList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
}
