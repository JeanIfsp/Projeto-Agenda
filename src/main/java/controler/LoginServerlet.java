package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import config.ConectionDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.TaskDao;
import dao.UserDao;
import model.Task;
import model.User;

/**
 * Servlet implementation class LoginServerlet
 */
@WebServlet(urlPatterns={"/login", "/"})
public class LoginServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServerlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			
			User user = UserDao.userExists(username,  password);
			
			if(user.getResultado()) {
				System.out.println("id do user:");
				System.out.println(user.getId());
				HttpSession session =request.getSession();
				session.setAttribute("userid", user.getId());  
			    session.setAttribute("login", user.getLogin());
			    request.setAttribute("iduser", user.getId());
			    System.out.println(user.getId());
				List<Task> taskList = TaskDao.getTask(String.valueOf(user.getId()));
				//System.out.println(taskList.get(1).getData_criacao());
				request.setAttribute("list", taskList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listTask.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}catch (SQLException e) {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
