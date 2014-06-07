package servlets;

import helpers.DBManager;
import helpers.Schedule;
import helpers.User;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HandleSchedules
 */
public class HandleSchedules extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleSchedules() {
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

		DBManager man = new DBManager();
		HttpSession session = request.getSession(true);
		Schedule schedule = new Schedule();
		User user = new User();
		response.setContentType("text/html");
		user.setId(Integer.parseInt(request.getParameter("usr").toString()
				.trim()));
		schedule.setDate_created(new Date());
		schedule.setDesc(request.getParameter("schedule"));
		schedule.setTag(request.getParameter("tag"));
		schedule.setUser(user);
		schedule.setDate_scheduled(request.getParameter("date"));
		if (man.createSchedule(schedule)) { // schedule created.
			session.setAttribute("status", "Schedule created");
			response.sendRedirect("admin.jsp");
		} else {
			session.setAttribute("status", "Schedule Not created");
			response.sendRedirect("admin.jsp?id=question");
		}

	}

}
