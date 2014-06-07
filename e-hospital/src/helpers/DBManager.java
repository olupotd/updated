package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

	private Connection con;
	private Statement st;
	private ResultSet set;

	public DBManager() {
		super();
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:sqlite:doctors.db");
			if (!con.isClosed()) {
				st = con.createStatement();
				st.executeUpdate("CREATE TABLE IF NOT EXISTS user(id integer primary key autoincrement, username varchar(60) not null, password varchar(60) not null, fullnames varchar(100) not null, email varchar(150) not null, location varchar(100) not null, contact varchar(100), dept varchar(100), is_staff varchar(50) not null)");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS post(id integer primary key autoincrement,headline varchar(100) not null, post tinytext not null unique, user_id integer not null, date_posted varchar(100) not null , img_url varchar(200) null)");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS comment(id integer primary key autoincrement, comment tinytext not null, user_id integer not null references user(id), date_posted varchar(100) not null , post_id integer null references post(id))");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS schedule(id integer primary key autoincrement, tag varchar(100) not null, schedule text, user_id integer references user(id), date_Created varchar(100), date_scheduled varchar(100) )");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS research(id integer primary key autoincrement, topic varchar(100) not null, Research text, user_id integer references user(id), date_Created varchar(100), department varchar(100), img_url varchar(100) )");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS contact(id integer primary key autoincrement, name varchar(100) not null, email varchar(100) not null, phone varchar(20), message tinytext not null )");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean success = false;

		try {
			int update = st
					.executeUpdate("insert into user(username, password, fullnames, email, location, contact, dept, is_staff) values(\""
							+ user.getUsername()
							+ "\",\""
							+ user.getPassword()
							+ "\",\""
							+ user.getFullnames()
							+ "\",\""
							+ user.getEmail()
							+ "\",\""
							+ user.getLocation()
							+ "\", \""
							+ user.getContact()
							+ "\", \""
							+ user.getDept()
							+ "\", \""
							+ user.isIs_staff()
							+ "\")");
			if (update > 0)
				success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	public User authenticate(User user) {
		try {
			set = st.executeQuery("SELECT * FROM user WHERE username = '"
					+ user.getUsername() + "' and password = '"
					+ user.getPassword() + "'");

			while (set.next()) {
				user.setContact(set.getString(7)); // contact
				user.setId(set.getInt(1));// userid
				user.setLocation(set.getString(6));// location
				user.setFullnames(set.getString(4));// fullnames
				user.setDept(set.getString(8));// dept
				user.setEmail(set.getString(5));// email
				user.setValid(true);
				user.setIs_staff(set.getString(9));// staff
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean updateInfo(User user) {
		// TODO Auto-generated method stub
		boolean ok = true;

		return ok;
	}

	public boolean createPost(Post post) {
		boolean ok = false;
		// add img_url if the url exists to the end of the list
		try {
			int update = st
					.executeUpdate("INSERT INTO post(headline, post, user_id, date_posted, img_url) values(\""
							+ post.getHeadline()
							+ "\",\""
							+ post.getPost()
							+ "\",\""
							+ post.getUser().getId()
							+ "\",\""
							+ post.getDate_posted()
							+ "\",\""
							+ post.getUrl()
							+ "\")");
			if (update > 0) {
				set = st.executeQuery("select id from post where date_posted = '"
						+ post.getDate_posted() + "'");
				post.setId(set.getInt(1));
				ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ok;
	}

	public boolean comment(Post post) {
		boolean ok = false;
		// TODO Auto-generated method stub
		// id integer primary key autoincrement, comment tinytext not null,
		// user_id integer not null references user(id), date_posted
		// varchar(100) not null , post_id integer null references post(id))

		try {
			for (String comm : post.getComments()) {
				int commented = st
						.executeUpdate("INSERT INTO comment(comment, user_id, date_posted, post_id) values(\""
								+ comm
								+ "\",\""
								+ post.getUser().getId()
								+ "\",\""
								+ post.getDate_posted()
								+ "\",\""
								+ post.getId() + "\")");

				if (commented > 0)
					ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}

	public List<String> getPosts() {
		List<String> posts = new ArrayList<String>();
		try {
			set = st.executeQuery("select post.id, post.headline, post.post, post.date_posted, post.img_url, user.fullnames from post, user order by post.id desc");
			while (set.next()) {
				posts.add(set.getInt(1) + "@" + set.getString(2) + "@"
						+ set.getString(3) + "@" + set.getInt(4) + "@"
						+ set.getString(5) + "@" + set.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posts;
	}

	public List<String> loadComments(Post i) {
		List<String> comments = new ArrayList<String>();
		try {
			// id integer primary key autoincrement, comment tinytext not null,
			// user_id integer not null references user(id), date_posted
			// varchar(100) not null , post_id integer null references post(id)
			set = st.executeQuery("select comment.comment, comment.date_posted, comment.post_id, user.fullnames from comment, user where post_id = "
					+ i.getId() + " and user_id = " + i.getUser().getId());
			while (set.next()) {
				comments.add(set.getString(1) + ";" + set.getShort(2) + ";"
						+ set.getInt(3) + ";" + set.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

	public boolean createSchedule(Schedule schedule) {
		boolean done = false;
		try {
			int update = st
					.executeUpdate("INSERT INTO schedule(tag, schedule, user_id, date_Created) values(\""
							+ schedule.getTag()
							+ "\",\""
							+ schedule.getDesc()
							+ "\",\""
							+ schedule.getUser().getId()
							+ "\",\""
							+ schedule.getDate_created() + "\")");
			if (update > 0)
				done = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return done;
	}

	public List<String> getSchedule(User user) {
		// TODO Auto-generated method stub
		List<String> schedules = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM schedule where user_id = "
					+ user.getId());
			while (set.next()) {
				schedules.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(5) + ";"
						+ set.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return schedules;
	}

	public boolean createResearch(Research research) {
		// TODO Auto-generated method stub
		// ey autoincrement, topic varchar(100) not null, Research text, user_id
		// integer references user(id), date_Created varchar(100), department
		// varchar(100)
		boolean created = false;

		try {
			int done = st
					.executeUpdate("INSERT INTO research(topic, Research, user_id, date_Created, department, img_url) values(\""
							+ research.getTopic()
							+ "\",\""
							+ research.getResearch().toString()
							+ "\",\""
							+ research.getUser().getId()
							+ "\",\""
							+ research.getDate_published()
							+ "\",\""
							+ research.getDept()
							+ "\", \""
							+ research.getUrl()
							+ "\")");
			if (done > 0)
				created = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return created;
	}

	public List<String> getallResearch() {
		// TODO Auto-generated method stub
		List<String> listings = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM research ");
			while (set.next()) {
				listings.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(5) + ";"
						+ set.getString(6) + ";" + set.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}

	public List<String> getResearch(User user) {
		// TODO Auto-generated method stub
		List<String> listings = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM research where user_id = "
					+ user.getId());
			while (set.next()) {
				listings.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(5) + ";"
						+ set.getString(6) + ";" + set.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}

	public List<String> getPost(Post user) {
		List<String> listings = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM post where id = "
					+ user.getId());
			while (set.next()) {
				listings.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(4) + ";"
						+ set.getString(5) + ";" + set.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}

	public String getUser(int id) {
		String user = null;
		try {
			set = st.executeQuery("SELECT fullnames from user where id in (select user_id from post where id = "
					+ id + ")");
			user = set.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// id integer primary key autoincrement, name varchar(100) not null, email
	// varchar(100) not null, phone integer(11), message text not null

	public boolean contact(Contact contact) {
		boolean success = false;
		try {
			int update = st
					.executeUpdate("INSERT INTO contact(name, email, phone, message) VALUES(\""
							+ contact.getNames()
							+ "\",\""
							+ contact.getEmail()
							+ "\",\""
							+ contact.getPhone()
							+ "\",\""
							+ contact.getMessage() + "\")");
			if (update > 0)
				success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	public List<String> getUsers() {
		List<String> listings = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM user where is_staff = 'NO'");
			while (set.next()) {
				listings.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(4) + ";"
						+ set.getString(5) + ";" + set.getString(6) + ";"
						+ set.getString(7) + ";" + set.getString(8) + ";"
						+ set.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}

	public boolean deleteUser(User lect) {
		boolean del = false;
		try {
			int k = st.executeUpdate("delete from user where id = "
					+ lect.getId());
			if (k > 0)
				del = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return del;
	}

	public List<String> getallSchedule() {
		List<String> schedules = new ArrayList<String>();
		try {
			set = st.executeQuery("SELECT * FROM schedule");
			while (set.next()) {
				schedules.add(set.getInt(1) + ";" + set.getString(2) + ";"
						+ set.getString(3) + ";" + set.getString(5) + ";"
						+ set.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return schedules;
	}
}
