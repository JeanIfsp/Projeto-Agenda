package controler;

import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.util.List;

import dao.TaskDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Task;

/**
 * Servlet implementation class EditTask
 */
@WebServlet("/EditTask")
public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditTask() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Task> taskList = TaskDao.getTaskId(request.getParameter("taskid"));
		request.setAttribute("list", taskList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editTask.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String description = request.getParameter("descricao");
        String status = request.getParameter("status");
        String idtask = request.getParameter("idtask");
        
        try {
            int value = TaskDao.updateTask(description, status, idtask);
        	List<Task> taskList = TaskDao.getTask( request.getParameter("iduser"));
    		request.setAttribute("list", taskList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListTasks");
		dispatcher.forward(request, response);
	}

}
