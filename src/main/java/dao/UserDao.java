package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import config.ConectionDatabase;

public class UserDao {
	
	public static User userExists(String username, String password) throws SQLException {
		
      		
		String SELECT_USER = "SELECT "
								+ " id,"
								+ "	login,"
							    + "	email,"
								+ "	nome,"
							    + "	CASE"
							    + "	WHEN login = ? AND password = ? THEN 'true'"
							    + "		ELSE 'false'"
							    + "	END AS Resultado"
							    + "	FROM user;";
						
		ResultSet rs;
		Connection connection = null;
		User user = new User();
		
		try {
		
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			System.out.println(rs);
		
			 while(rs.next()) {
				 
				 user.setId(rs.getInt("id"));
				 user.setLogin(rs.getString("login"));
				 user.setEmail(rs.getString("email"));
				 user.setNome(rs.getString("nome"));
				 user.setResultado(rs.getBoolean("Resultado"));   
			 }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//connection.close();
		}
		System.out.println(user.getResultado());
		return user;
		
	}
	
	public static boolean validateUserExists(String login, String email) throws SQLException {
		
		String SELECT_USER = "SELECT "
				+ "  CASE WHEN EXISTS ("
				+ "    SELECT 1"
				+ "    FROM user"
				+ "    WHERE login = '?' OR email = '?'"
				+ "  ) THEN 'Verdadeiro' ELSE 'Falso' END AS status;";
		
		ResultSet rs;
		Connection connection = null;
		User user = new User();
		
		try {
		
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, email);
			rs = preparedStatement.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
			 user.setResultado(rs.getBoolean("Resultado"));   
			}
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
		//connection.close();
		}
		return user.getResultado();
		
	}
}
