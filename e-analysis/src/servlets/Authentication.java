package servlets;

import helpers.Manager;
import helpers.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authentication
 */
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Manager manage = new Manager();
		User user = new User();
		user.setRegNo(request.getParameter("regNo").trim());
		user.setStudentNo(request.getParameter("studentNo").trim());

		PrintWriter pr = response.getWriter();
		response.setContentType("text/html");

		boolean valid = manage.authenticate(user);
		if (valid == true) {
			HttpSession session = request.getSession();
			session.setAttribute("fullnames", user.getFullnames());
			session.setAttribute("ID", user.getId());
			List<String> lecturers = manage.getLeturers(user);
			request.setAttribute("lecturers", lecturers);
			pr.println("Loading data....");

			if (user.getRegNo().contains("/")) // if the user is a student
			{
				session.setAttribute("type", "student");
				session.setAttribute("logged_in", "true");
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			} else {
				List<String> lecturer = manage.getallLects();
				List<String> results = manage.getResults();
				// this person is an administrator
				session.setAttribute("type", "admin");
				session.setAttribute("lecturers", lecturer);
				session.setAttribute("analysis", results);
				response.sendRedirect("admin.jsp");
			}
		} else {
			// pr.println("invalid user");
			request.setAttribute("status", "Invalid username or password");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}
}
