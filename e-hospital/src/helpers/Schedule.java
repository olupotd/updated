package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {

	private User user;
	private String tag;
	private String desc;
	private String date_created;
	private String date_scheduled;
	private SimpleDateFormat format;

	public Schedule() {
		super();
		this.format = new SimpleDateFormat("HH:mm dd/MM/YYYY");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date) {
		this.date_created = format.format(date);
	}

	public String getDate_scheduled() {
		return date_scheduled;
	}

	public void setDate_scheduled(String date_scheduled) {
		this.date_scheduled = date_scheduled;
	}

}
