package com.callor.food.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;
	
	static {
		String jdbcDriver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="food";
		String password="food";
		
		try {
			Class.forName(jdbcDriver);
			dbConn=DriverManager.getConnection(url, username, password);
			System.out.println("DB 연결 ㅇㅋ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 DB DRIVER 없음");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 DB연결 오류");
		}
		
	}
	public static Connection getDBConnection() {
		return dbConn;
	}
}
