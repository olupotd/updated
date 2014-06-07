package servlets;

import helpers.DBManager;
import helpers.Post;
import helpers.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Parser
 */
public class Parser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Parser() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (!session.getAttribute("state").equals(null)) {
			DBManager dbman = new DBManager();
			User user = new User();
			user.setId(Integer.parseInt(session.getAttribute("ID").toString()));
			Post post = new Post();
			post.setId(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("PID", post.getId());
			post.setUser(user);
			request.setAttribute("creator", dbman.getUser(post.getId()));
			request.setAttribute("single_post", dbman.getPost(post));
			request.setAttribute("comments", dbman.loadComments(post));
			request.getRequestDispatcher("single.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("welcome");

		}
	}
}
