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
	
//=============================관리자
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
}
