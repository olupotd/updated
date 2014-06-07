package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Research {

	private String topic;
	private int id;
	private User user;
	private String research;
	private String date_published;
	private String dept, url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getDate_published() {
		return date_published;
	}

	public void setDate_published(Date date_published) {
		this.date_published = new SimpleDateFormat("HH:mm dd/MM/YYYY")
				.format(date_published);
	}

}
