package servlets;

import helpers.Manager;
import helpers.User;

import java.io.IOException;
import java.util.List;

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
		// TODO Auto-generated method stub

		Manager manage = new Manager();
		User user = new User();
		user.setRegNo(request.getParameter("username"));
		user.setStudentNo(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setFullnames(request.getParameter("fullnames"));

		boolean valid = manage.register(user);
		if (valid == true) {
			manage.authenticate(user);
			HttpSession session = request.getSession();
			session.setAttribute("fullnames", user.getFullnames());
			session.setAttribute("ID", user.getId());
			session.setAttribute("username", user.getRegNo());
			if (user.getRegNo().contains("/")) {
				List<String> lecturers = manage.getLeturers(user);
				request.setAttribute("lecturers", lecturers);
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			} else
				// this person is an administrator
				request.getRequestDispatcher("admin.jsp").forward(request,
						response);
		} else {
			// pr.println("invalid user");
			request.setAttribute("status", "Invalid username or password");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

}
