package mvc.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvc.com.bean.UserBEAN;
import mvc.com.bean.todosBEAN;
import mvc.com.dao.UserDAO;
import mvc.com.dao.todosDAO;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.User;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		UserDAO dao = new UserDAO();
		todosDAO daotodo = new todosDAO();
		
		String action = request.getParameter("action");
		System.out.println("Action : "+action);
		
		if(action.equals("register")) {
			UserBEAN bean = new UserBEAN();
			bean.setFirst_name(request.getParameter("firstname"));
			bean.setLast_name(request.getParameter("lastname"));
			bean.setUsername(request.getParameter("username"));
			bean.setPassword(request.getParameter("password"));
			
			String result = dao.register(bean);
			if(result.equals("success")) {
				ArrayList<UserBEAN> user = dao.getAll();
				session.setAttribute("user", user);
				//request.setAttribute("NOTIFICATION", "Registered");
				response.sendRedirect("pages/login.jsp");
			}else{
				response.sendRedirect("pages/register.jsp");
			}
		}
		
		if(action.equals("login")) {
			UserBEAN bean = new UserBEAN();
			bean.setLoginusername(request.getParameter("loginusername"));
			bean.setLoginpassword(request.getParameter("loginpassword"));
			
			String result = dao.login(bean);
			if(result.equals("success")) {
				ArrayList<todosBEAN> user = daotodo.getAll();
				
				session.setAttribute("user", user);
				response.sendRedirect("pages/todo-list.jsp");
			}else {
				response.sendRedirect("pages/login.jsp");
			}
		}
		
		if(action.equals("login-user")) {
			UserBEAN bean = new UserBEAN();
			bean.setLoginusername(request.getParameter("loginusername"));
			bean.setLoginpassword(request.getParameter("loginpassword"));
			
			String result = dao.login(bean);
			if(result.equals("success")) {
				ArrayList<UserBEAN> user = dao.getAll();
				
				session.setAttribute("user", user);
				response.sendRedirect("pages/users-viewAll.jsp");
			}else {
				response.sendRedirect("pages/login-users.jsp");
			}
		}
		
		if(action.equals("edit")) {
			String id = request.getParameter("id");
			
			UserBEAN user = dao.edit(id);
			session.setAttribute("user", user);
			response.sendRedirect("pages/register-update.jsp");
		}
		
		if(action.equals("update")) {
			UserBEAN bean = new UserBEAN();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setFirst_name(request.getParameter("firstname"));
			bean.setLast_name(request.getParameter("lastname"));
			bean.setUsername(request.getParameter("username"));
			bean.setPassword(request.getParameter("password"));
			
			String result = dao.update(bean);
			if(result.equals("success")) {
				ArrayList<UserBEAN> user = dao.getAll();
				
				session.setAttribute("user", user);
				response.sendRedirect("pages/users-viewAll.jsp");
			}else {
				response.sendRedirect("pages/register-update.jsp");
			}
		}
		
		if(action.equals("delete")) {
			String id = request.getParameter("id");
			
			String result = dao.delete(id);
			if(result.equals("success")) {
				ArrayList<UserBEAN> user = dao.getAll();
				session.setAttribute("user", user);
				response.sendRedirect("pages/users-viewAll.jsp");
			}
		}
	}
}