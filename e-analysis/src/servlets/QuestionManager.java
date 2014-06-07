package servlets;

import helpers.Manager;
import helpers.Question;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuestionManager
 */
public class QuestionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionManager() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Manager man = new Manager();
		Question question = new Question();
		@SuppressWarnings("unchecked")
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String ans = names.nextElement();
			String[] vals = request.getParameterValues(ans);
			for (int i = 0; i < vals.length; i++) {
				question.setQuestion(vals[i]);
				man.addQuestion(question);
			}
		}
		session.setAttribute("status", "Question added succesfully");
		response.sendRedirect("admin.jsp");

	}

}