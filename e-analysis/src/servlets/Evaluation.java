package servlets;

import helpers.Lecturer;
import helpers.Manager;
import helpers.User;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Evaluation
 */
public class Evaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Evaluation() {
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
		@SuppressWarnings("unchecked")
		Enumeration<String> names = request.getParameterNames();
		Manager man = new Manager();
		Lecturer lect = new Lecturer();

		lect.setId(session.getAttribute("lect_id").toString());
		User std = new User();
		std.setId(session.getAttribute("ID").toString());
		response.setContentType("text/html");
		while (names.hasMoreElements()) {
			String ans = names.nextElement();
			String[] vals = request.getParameterValues(ans);
			for (int i = 0; i < vals.length; i++) {
				man.evaluate(lect, ans + ";" + vals[i], std);
			}
		}
		List<String> lecturers = man.getLeturers(std);
		request.setAttribute("lecturers", lecturers);
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

}
