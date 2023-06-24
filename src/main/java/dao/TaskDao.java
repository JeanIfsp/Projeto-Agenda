package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import config.ConectionDatabase;
import model.Task;


public class TaskDao {
	
	public static List<Task> getTask(String idUser){
		
		
		String SQL_TASK = "SELECT * FROM task WHERE ID_USER = ? AND STATUS <> 'Concluída' ORDER BY ID DESC"; 
		
		List<Task> listTask = new ArrayList<Task>(); 
		Connection connection = null;
		
		try {
			
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_TASK);
			preparedStatement.setString(1, idUser);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Task task = new Task();
				task.setId(rs.getInt("id"));
				System.out.println(task.getId());
				task.setTitulo(rs.getString("titulo"));
				task.setDescricao(rs.getString("descricao"));
				task.setData_criacao(rs.getDate("data_criacao"));
				task.setData_conclusao(rs.getDate("data_conclusao"));
				task.setStatus(rs.getString("status"));
				task.setId_user(rs.getInt("id_user"));
				System.out.println(task.getData_criacao());
				listTask.add(task);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return listTask;
	}
	
	public static List<Task> getTaskId(String taskId){
		
		String SQL_TASK_ID = "SELECT * FROM task WHERE ID = ?"; 
		
		List<Task> listTaskId = new ArrayList<Task>(); 
		Connection connection = null;
		
		try {
	
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_TASK_ID);
			preparedStatement.setString(1, taskId);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("consulta taskid");
			while(rs.next()) {
				
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setDescricao(rs.getString("descricao"));
				task.setData_criacao(rs.getDate("data_criacao"));
				task.setData_conclusao(rs.getDate("data_conclusao"));
				task.setStatus(rs.getString("status"));
				task.setId_user(rs.getInt("id_user"));
				listTaskId.add(task);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return listTaskId;
	}
	
	public static int updateTask(String description, String status, String idtask) {
		
		String SQL_UPDATE_TASK = "UPDATE task SET descricao = ?, status = ? where id = ?";
		Connection connection = null;
		int transection = 0;
		
		try {
			
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_TASK);
			
			//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(description);
			System.out.println(status);
			System.out.println(idtask);
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, status);
			preparedStatement.setInt(3, Integer.parseInt(idtask));
			
			return preparedStatement.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			return transection;
		}
		
		
	}
	
	public static int deleteTaks(String idtask){
		
		Connection connection = null;
		String SQL_DELETE = "DELETE FROM task WHERE ID = ?";
		int transection = 0;
		
		try {
			
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1,  Integer.parseInt(idtask));
			transection =  preparedStatement.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return transection;
	}

	public static int insertTask(Task task) {
		String INSERT_TASK = "INSERT INTO task (titulo, descricao, data_criacao, data_conclusao, status, id_user)"+
				"VALUES (?, ?, ?, ?, ?, ?);";	

		Connection connection = null;
		int transection = 0;
				
		try {
			
			connection = ConectionDatabase.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK);
			
			preparedStatement.setString(1, task.getTitulo());
			preparedStatement.setString(2, task.getDescricao());
			preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
			preparedStatement.setDate(4, null);
			preparedStatement.setString(5, task.getStatus());
			preparedStatement.setInt(6, task.getId_user());
			
			return preparedStatement.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			return transection;
		}
	}
	
}
	
