package servlets;

import helpers.DBManager;
import helpers.Research;
import helpers.User;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class Researcher
 */
public class Researcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Researcher() {
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
	 *      response) /addresearcb
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Research article = new Research();
		User user = new User();
		user.setId(Integer.parseInt(session.getAttribute("ID").toString()));
		DBManager man = new DBManager();
		List<FileItem> items = null;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory())
					.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (FileItem item : items) {
			if (item.isFormField()) {
				if (item.getFieldName().equalsIgnoreCase("topic"))
					article.setTopic(item.getString());
				else
					article.setResearch(item.getString());
				continue;
			} else {
				try {
					String filename = FilenameUtils.getName(item.getName());
					String path = getServletContext().getRealPath("");
					File file = new File(path, filename);
					item.write(file);
					article.setUrl(filename);
				} catch (FileUploadException e) {
					throw new ServletException(
							"Cannot parse multipart request.", e);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		response.setContentType("image/jpg");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/research.jsp");
		article.setUser(user);
		article.setDate_published(new Date());
		if (man.createResearch(article)) {
			session.setAttribute("articles", man.getallResearch());
			dispatcher.forward(request, response);
		}
	}

}
