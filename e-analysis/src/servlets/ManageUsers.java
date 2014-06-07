package servlets;

import helpers.Lecturer;
import helpers.Manager;
import helpers.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageUsers
 */
public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageUsers() {
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
		// username
		HttpSession session = request.getSession(true);
		boolean added = false;
		Manager man = new Manager();
		String option = request.getParameter("value");
		if (option.equalsIgnoreCase("S")) {
			// student
			User user = new User();
			user.setEmail(request.getParameter("email"));
			user.setFullnames(request.getParameter("fullnames"));
			user.setRegNo(request.getParameter("username"));
			user.setStudentNo(request.getParameter("password"));
			added = man.register(user);
			if (added) {
				session.setAttribute("new_list", man.getallLects());
				session.setAttribute("status", user.getFullnames()
						+ " has been added");
				response.sendRedirect("admin.jsp");

			} else {
				session.setAttribute("status", user.getFullnames()
						+ " Not added.");
				response.sendRedirect("admin.jsp");

			}

		}
		if (option.equalsIgnoreCase("L")) {
			Lecturer lect = new Lecturer();
			lect.setDepart(request.getParameter("dept"));
			lect.setFullnames(request.getParameter("fullnames"));
			lect.setDate_reg(new Date());
			lect.setEmail(request.getParameter("email"));
			lect.setPassword(request.getParameter("password"));
			lect.setLocation(request.getParameter("loct"));
			lect.setPhone(request.getParameter("phone"));
			lect.setUsername(request.getParameter("username"));
			// needs to be updated.
			added = man.addLecturer(lect);
			if (added) {
				session.setAttribute("status", lect.getFullnames()
						+ " has been added");
				List<String> lecturer = man.getallLects();
				// this person is an administrator
				session.setAttribute("lecturers", lecturer);
				response.sendRedirect("admin.jsp");

			} else {
				session.setAttribute("status", lect.getFullnames()
						+ " Not added.");
				response.sendRedirect("admin.jsp");
			}

		}

	}

}
