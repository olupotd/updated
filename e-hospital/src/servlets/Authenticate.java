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
 * Servlet implementation class Authenticate
 */
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticate() {
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
		HttpSession session = request.getSession(true);
		session.removeAttribute("ID");
		session.removeAttribute("fullnames");
		session.removeAttribute("posts");
		session.removeAttribute("creator");
		session.removeAttribute("single_post");
		session.removeAttribute("articles");
		session.removeAttribute("PID");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DBManager manager = new DBManager();
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		boolean valid = manager.authenticate(user).isValid();
		if (valid) {
			HttpSession session = request.getSession(true);
			session.setAttribute("state", "LoggedIn");
			session.setAttribute("fullnames", user.getFullnames());
			session.setAttribute("ID", user.getId());
			session.setAttribute("location", user.getLocation());
			session.setAttribute("contact", user.getContact());
			session.setAttribute("dept", user.getDept());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("posts", manager.getPosts());
			session.setAttribute("articles", manager.getallResearch());
			session.setAttribute("users", manager.getUsers());
			if (user.isIs_staff().equalsIgnoreCase("YES")) {
				session.setAttribute("schedules", manager.getallSchedule());
				response.sendRedirect("admin.jsp");
			} else {
				session.setAttribute("schedules", manager.getSchedule(user));
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			}

		} else {
			// failed to login and taken back to the login page.
			request.setAttribute("status",
					"Error: Invalid username and or password");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}

	}
}
