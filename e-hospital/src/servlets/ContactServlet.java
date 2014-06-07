package servlets;

import helpers.Contact;
import helpers.DBManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
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
		DBManager manager = new DBManager();
		Contact contact = new Contact();
		contact.setNames(request.getParameter("name"));
		contact.setEmail(request.getParameter("email"));
		contact.setPhone(request.getParameter("phone"));
		contact.setMessage(request.getParameter("message"));
		if (manager.contact(contact)) {
			request.setAttribute("status",
					"Your message was received. We'll get back to you as soon as possible");
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		} else {
			request.setAttribute("status",
					"There was an error while sending your message. Please review and try again");
			request.getRequestDispatcher("contact.jsp").forward(request,
					response);
		}
	}

}
