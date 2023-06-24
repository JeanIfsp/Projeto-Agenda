package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDatabase {


	private static Connection conn;
	
	public static Connection getConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(conn == null) {
				conn =  DriverManager.getConnection("jdbc:mysql://192.168.196.98:3306/schedule", "root", "root");
				return conn;
			}
			return conn;
		}catch(ClassNotFoundException |SQLException e) {
			return null;
		}
	}
}
