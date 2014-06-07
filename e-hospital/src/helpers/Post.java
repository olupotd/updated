package helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private int id;
	private String post, headline;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	private List<String> comments;
	private User user;
	private String date_posted;
	private SimpleDateFormat format;

	public Post() {
		super();
		this.format = new SimpleDateFormat("HH mm dd/MM/YYYY");
		this.comments = new ArrayList<String>();
	}

	public String getDate_posted() {
		return date_posted;
	}

	public void setDate_posted(Date date_posted) {
		this.date_posted = format.format(date_posted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public List<String> getComments() {
		return comments;
	}

	public void addComments(String comments) {
		this.comments.add(comments);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
