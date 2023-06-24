package controler;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Task;
import dao.TaskDao;

/**
/**
 * Servlet implementation class CreateTask
 */
@WebServlet("/createTask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateTask() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/createTask.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         
    	HttpSession session=request.getSession(false);  
		String userid = (String) session.getAttribute("userid");
        
		Task task = new Task();
		task.setTitulo(request.getParameter("titulo"));
		task.setDescricao(request.getParameter("descricao"));
		task.setStatus(request.getParameter("status"));
		task.setId_user(5);
		System.out.println(request.getParameter("iduser"));
        try {
            int value = TaskDao.insertTask(task);
        	List<Task> taskList = TaskDao.getTask(userid);
    		request.setAttribute("list", taskList);
            System.out.println("funcionou ;)");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListTasks");
		dispatcher.forward(request, response);
    }

}
