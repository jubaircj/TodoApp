package mvc.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvc.com.bean.todosBEAN;
import mvc.com.dao.todosDAO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Servlet implementation class todosController
 */
public class todosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public todosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		todosDAO daotodo = new todosDAO();
		String action = request.getParameter("action");
		System.out.println("Action : "+action);
		
		if(action.equals("insert")) {
			todosBEAN bean = new todosBEAN();
			bean.setTitle(request.getParameter("title"));
			bean.setDescription(request.getParameter("description"));
			bean.setStatus(request.getParameter("status"));
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String targetDateParameter = request.getParameter("target_date");
			LocalDate target_date = LocalDate.parse(targetDateParameter, df);
	        bean.setTarget_date(target_date);
	        
			/*
			System.out.println("Received target_date parameter: " + targetDateParameter);
			
			System.out.println("Length of target_date parameter: " + targetDateParameter.length());

			 */
			
			String result = daotodo.insert(bean);
			if(result.equals("success")) {
				ArrayList<todosBEAN> user = daotodo.getAll();
				session.setAttribute("user", user);
				response.sendRedirect("pages/todo-list.jsp");
				
			}else {
				response.sendRedirect("pages/todo-form-insert.jsp");
			}
		}
		if(action.equals("edit")) {
			String id = request.getParameter("id");
			
			todosBEAN user = daotodo.edit(id);
			session.setAttribute("user", user);
			response.sendRedirect("pages/todo-form-update.jsp");
		}
		
		if(action.equals("update")) {
			todosBEAN bean = new todosBEAN();
			bean.setTitle(request.getParameter("title"));
			bean.setDescription(request.getParameter("description"));
			bean.setStatus(request.getParameter("status"));
			
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String targetDateParameter = request.getParameter("target_date");
			LocalDate target_date = LocalDate.parse(targetDateParameter, df);
	        bean.setTarget_date(target_date);
	        /*
			System.out.println("Received target_date parameter: " + targetDateParameter);
			System.out.println("Length of target_date parameter: " + targetDateParameter.length());
			
			*/
	        String idParameter = request.getParameter("id");
	        System.out.println(idParameter);
	        if (idParameter != null) {
	            bean.setId(Integer.parseInt(idParameter));
	        } else {
	            // Handle the case where the "id" parameter is null
	            // For example, you might set a default value or display an error message.
	        }
	        String result = daotodo.update(bean);
			if(result.equals("success")) {
				ArrayList<todosBEAN> user = daotodo.getAll();
				
				session.setAttribute("user", user);
				response.sendRedirect("pages/todo-list.jsp");
			}else {
				response.sendRedirect("pages/todo-form-update.jsp");
			}
		}
		if(action.equals("delete")) {
			String id = request.getParameter("id");
			
			String result = daotodo.delete(id);
			if(result.equals("success")) {
				ArrayList<todosBEAN> user = daotodo.getAll();
				session.setAttribute("user", user);
				response.sendRedirect("pages/todo-list.jsp");
			}
		}
	}	
}