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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Delete() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("foget edit task");
		List<Task> taskList = TaskDao.getTaskId(request.getParameter("taskid"));
		request.setAttribute("list", taskList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/deleteTask.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String idtask = request.getParameter("idtask");
        try {
            int value = TaskDao.deleteTaks(idtask);
            System.out.println(value);
        	List<Task> taskList = TaskDao.getTask( request.getParameter("iduser"));
    		request.setAttribute("list", taskList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listTask.jsp");
		dispatcher.forward(request, response);
	}

}
