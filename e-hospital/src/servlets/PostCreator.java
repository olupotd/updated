package servlets;

import helpers.DBManager;
import helpers.Post;
import helpers.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class PostCreator
 */
public class PostCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostCreator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter pr = response.getWriter();
		response.setContentType("text/html");
		Post post = new Post();
		User user = new User();
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
				if (item.getFieldName().equalsIgnoreCase("headline"))
					post.setHeadline(item.getString());
				post.setPost(item.getString());
				continue;
			} else {
				try {
					String filename = FilenameUtils.getName(item.getName());
					String path = getServletContext().getRealPath("");
					File file = new File(path, filename);
					item.write(file);
					post.setUrl(filename);
				} catch (FileUploadException e) {
					throw new ServletException(
							"Cannot parse multipart request.", e);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			response.setContentType("image/jpg");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/blog.jsp");
			user.setId(Integer.parseInt(session.getAttribute("ID").toString()));
			post.setDate_posted(new Date());
			post.setUser(user);
			try {
				boolean isposted = man.createPost(post);
				session.removeAttribute("posts");
				session.setAttribute("posts", man.getPosts());
				if (isposted == true && response.isCommitted()) {
					request.setAttribute("status", "Succesfuly posted");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("status",
							"Not Succesful  when posting");
					session.setAttribute("status", "Article not posted");
					pr.print("Content has not been saved.");
					dispatcher.forward(request, response);
				}
			} catch (Exception sql) {
				request.setAttribute("status",
						"Post is similar to previous one");
				dispatcher.forward(request, response);
			}
		}

	}
}
