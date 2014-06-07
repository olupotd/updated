package servlets;

import helpers.DBManager;
import helpers.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Handler
 */
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Handler() {
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
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		DBManager man = new DBManager();
		User lect = new User();
		lect.setId(Integer.parseInt(id.toString()));
		if (!id.equalsIgnoreCase(null)) {
			boolean ok = man.deleteUser(lect);
			if (ok) {
				session.setAttribute("status", "User Deleted.");
				List<String> lecturer = man.getUsers();
				// this person is an administrator
				session.setAttribute("users", lecturer);
				response.sendRedirect("admin.jsp");
			} else {
				session.setAttribute("status", "Unable to delete lecturer.");
				response.sendRedirect("admin.jsp");
			}
		} else {
			session.setAttribute("status",
					"No lecturer was selected. None deleted.");
			response.sendRedirect("admin.jsp");
		}
	}

}
