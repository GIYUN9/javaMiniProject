package com.kh.miniProject_product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.miniProject_product.common.JDBCTemplate;
import com.kh.miniProject_product.model.vo.Product;

public class MiniDao {
	
	private Properties prop = new Properties();
	
	public MiniDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}
