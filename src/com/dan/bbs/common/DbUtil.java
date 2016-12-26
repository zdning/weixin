package com.dan.bbs.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接工厂
 * @author Administrator
 *
 */
public class DbUtil {
	
	
	public static Connection getConnection() throws Exception {
						
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/news";
		String user = "root";
		String password = "000000";
		
		Connection conn = DriverManager.getConnection(url, user,password);
		return conn;
		
	}
}