package servlets;

import helpers.DBManager;
import helpers.Research;
import helpers.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Collector
 */
public class Collector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Collector() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
			Research research = new Research();
			research.setId(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("RID", research.getId());
			research.setUser(user);
			request.setAttribute("creator", dbman.getUser(research.getId()));
			request.setAttribute("single_post", dbman.getResearch(user));
			request.getRequestDispatcher("review.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("welcome");

		}
	}

}
