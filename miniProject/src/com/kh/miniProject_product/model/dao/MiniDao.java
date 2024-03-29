package com.kh.miniProject_product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.miniProject_product.common.JDBCTemplate;
import com.kh.miniProject_product.model.vo.Customer;
import com.kh.miniProject_product.model.vo.Product;
import com.kh.miniProject_product.model.vo.Trading;

public class MiniDao {
	
	private Properties prop = new Properties();
	
	public MiniDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
//===========================고객	
	public ArrayList<Product> selectList(Connection conn){
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setPro_no(rset.getInt("PRO_NO"));
				p.setPro_name(rset.getString("PRO_NAME"));
				p.setPro_price(rset.getInt("PRO_PRICE"));
				p.setPro_amount(rset.getInt("PRO_AMOUNT"));
				p.setPro_description(rset.getString("PRO_DESCRIPTION"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Product> selectByProName(Connection conn, String pro_name) {
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByProName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+pro_name+"%");
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Product p = new Product();
				p.setPro_no(rset.getInt("PRO_NO"));
				p.setPro_name(rset.getString("PRO_NAME"));
				p.setPro_price(rset.getInt("PRO_PRICE"));
				p.setPro_amount(rset.getInt("PRO_AMOUNT"));
				p.setPro_description(rset.getString("PRO_DESCRIPTION"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Trading> tradingList(Connection conn, int cus_no){
		ArrayList<Trading> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("tradingList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cus_no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Trading t = new Trading();
				t.setTra_no(rset.getInt("TRA_NO"));
				t.setCus_no(rset.getInt("CUS_NO"));
				t.setPro_no(rset.getInt("PRO_NO"));
				t.settra_amount(rset.getInt("TRA_AMOUNT"));
				t.setTra_method(rset.getString("TRA_METHOD"));
				t.setTra_date(rset.getDate("TRA_DATE"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int insertTrading(Connection conn, Trading t) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertTrading");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, t.getCus_no());
			pstmt.setInt(2, t.getPro_no());
			pstmt.setInt(3, t.gettra_amount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int insertCustomer(Connection conn, Customer c) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCustomer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCus_id());
			pstmt.setString(2, c.getCus_pwd());
			pstmt.setString(3, c.getNickName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int customerLoginMenu(Connection conn, String id, String pwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("customerLoginMenu");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	public ArrayList<Customer> selectCustomerInfo(Connection conn, String id, String pwd){
		ArrayList<Customer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCustomerInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Customer c = new Customer();
				c.setCus_no(rset.getInt("CUS_NO"));
				c.setCus_id(rset.getString("CUS_ID"));
				c.setCus_pwd(rset.getString("CUS_PWD"));
				c.setNickName(rset.getString("NICKNAME"));
				c.setEnrolldate(rset.getDate("ENROLLDATE"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
//=============================관리자
	
	public int adminLoginMenu(Connection conn, String id, String pwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminLoginMenu");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	public int insertProduct(Connection conn, Product p) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getPro_name());
			pstmt.setInt(2, p.getPro_price());
			pstmt.setInt(3, p.getPro_amount());
			pstmt.setString(4, p.getPro_description());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int delectProduct(Connection conn, int pro_no) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("delectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateProduct(Connection conn, Product p) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPro_name());
			pstmt.setInt(2, p.getPro_price());
			pstmt.setInt(3, p.getPro_amount());
			pstmt.setString(4, p.getPro_description());
			pstmt.setInt(5, p.getPro_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Customer> selectCustomerList(Connection conn){
		ArrayList<Customer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCustomerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Customer c = new Customer();
				c.setCus_no(rset.getInt("CUS_NO"));
				c.setCus_id(rset.getString("CUS_ID"));
				c.setCus_pwd(rset.getString("CUS_PWD"));
				c.setNickName(rset.getString("NICKNAME"));
				c.setEnrolldate(rset.getDate("ENROLLDATE"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Trading> selectTradingList(Connection conn){
		ArrayList<Trading> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTradingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Trading t = new Trading();
				t.setTra_no(rset.getInt("TRA_NO"));
				t.setCus_no(rset.getInt("CUS_NO"));
				t.setPro_no(rset.getInt("PRO_NO"));
				t.settra_amount(rset.getInt("TRA_AMOUNT"));
				t.setTra_method(rset.getString("TRA_METHOD"));
				t.setTra_date(rset.getDate("TRA_DATE"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
}
