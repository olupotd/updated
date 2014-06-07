package servlets;

import helpers.DBManager;
import helpers.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DBManager man = new DBManager();
		User user = new User();
		user.setContact(request.getParameter("phone"));
		user.setDept(request.getParameter("dept"));
		user.setEmail(request.getParameter("email"));
		user.setFullnames(request.getParameter("fullnames"));
		user.setLocation(request.getParameter("loct"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));
		if (request.getParameter("value").equalsIgnoreCase("A"))
			user.setIs_staff("YES");
		else
			user.setIs_staff("NO");

		boolean registered = man.registerUser(user);
		if (registered) {
			HttpSession session = request.getSession(true);
			session.setAttribute("users", man.getUsers());
			session.setAttribute("status", user.getFullnames() + " added.");
			response.sendRedirect("admin.jsp");

		} else {
			request.setAttribute("status", "User not added..");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

}
