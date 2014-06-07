package servlets;

import helpers.DBManager;
import helpers.Post;
import helpers.User;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Commenter
 */
public class Commenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Commenter() {
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
			post.setId(Integer.parseInt(session.getAttribute("PID").toString()));
			post.setUser(user);
			post.setDate_posted(new Date());
			post.addComments(request.getParameter("comment"));
			if (dbman.comment(post)) {
				request.setAttribute("creator", dbman.getUser(post.getId()));
				request.setAttribute("single_post", dbman.getPost(post));
				request.setAttribute("comments", dbman.loadComments(post));
				request.getRequestDispatcher("single.jsp").forward(request,
						response);
			} else {
				request.setAttribute("creator", dbman.getUser(post.getId()));
				request.setAttribute("single_post", dbman.getPost(post));
				request.setAttribute("comments", dbman.loadComments(post));
				request.setAttribute("status", "Comment not added");
				request.getRequestDispatcher("single.jsp").forward(request,
						response);
			}
		} else {
			response.sendRedirect("welcome");

		}
	}

}
