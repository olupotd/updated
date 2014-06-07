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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		Manager man = new Manager();
		User stud = new User();
		stud.setId(session.getAttribute("ID").toString());
		List<String> qs = man.getQuestions();
		request.setAttribute("test", "Successful");
		request.setAttribute("lecturer", man.getLecturer(id));
		session.setAttribute("lect_id", id);
		request.setAttribute("questions", qs);
		request.getRequestDispatcher("evaluation.jsp").forward(request,
				response);

	}
}
