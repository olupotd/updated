package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Manager {

	private Connection con;
	private Statement st;
	private ResultSet result;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:dataapp.db");
			if (!con.isClosed())
				st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, regNo VARCHAR(20) UNIQUE NOT NULL, studNo VARCHAR(20) UNIQUE NOT NULL, fullnames VARCHAR(30), email VARCHAR(20) NULL)");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS lecturer (id INTEGER PRIMARY KEY AUTOINCREMENT,  username varchar(100) not null, password varchar(100) not null, fullnames varchar(150) not null, email varchar(150) not null, phone integer null, Location varchar(100) null, department varchar(100) not null)");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS question(id INTEGER PRIMARY KEY AUTOINCREMENT, question varchar(100))");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS evaluation(id INTEGER PRIMARY KEY AUTOINCREMENT, quest_id INTEGER , eval VARCHAR(100), lect_id INTEGER, stud_id INTEGER, FOREIGN KEY(quest_id)  REFERENCES question(id), FOREIGN KEY(lect_id) REFERENCES lecturer(id),  FOREIGN KEY(stud_id)  REFERENCES user(id) )");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS evaluated(id INTEGER PRIMARY KEY AUTOINCREMENT, lect_id INTEGER NOT NULL, stud_id integer NOT NULL, FOREIGN KEY(lect_id) REFERENCES lecturer(id), FOREIGN KEY(stud_id) references user(id))");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS report(id INTEGER PRIMARY KEY AUTOINCREMENT, lect_id INTEGER NOT NULL, score integer NOT NULL, total integer not null, recommendation VARCHAR(100) NOT NULL, alerted varchar(5) null, FOREIGN KEY(lect_id) REFERENCES lecturer(id))");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean register(User stud) {
		// TODO Auto-generated method stub
		boolean registered = false;
		try {
			int ok = st
					.executeUpdate("INSERT INTO user(regNo, studNo, email, fullnames) VALUES('"
							+ stud.getRegNo()
							+ "','"
							+ stud.getStudentNo()
							+ "','"
							+ stud.getEmail()
							+ "','"
							+ stud.getFullnames() + "')");
			if (ok > 0)
				registered = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registered;
	}

	public boolean authenticate(User stud) {

		boolean done = false;
		try {
			result = st.executeQuery("SELECT * FROM user WHERE regNo = '"
					+ stud.getRegNo() + "' and studNo = '"
					+ stud.getStudentNo() + "'");

			while (result.next()) {
				stud.setId(String.valueOf(result.getInt(1)));
				stud.setFullnames(result.getString(4));
				stud.setEmail(result.getString(5));
				done = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return done;
	}

	public List<String> getAnalysis(Lecturer lecturer) {
		// TODO Auto-generated method stub
		List<String> answers = new ArrayList<>();
		try {
			result = st
					.executeQuery("select * from evaluation where lect_id = '"
							+ lecturer.getId() + "'");
			while (result.next()) {
				answers.add("Question_id: " + result.getInt(2) + " Answer:"
						+ result.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	public boolean makeReport(String string, int[] results) {
		// TODO Auto-generated method stub

		return false;
	}

	public String getLecturer(String id) {

		String details = null;
		try {
			result = st.executeQuery("SELECT * FROM lecturer where id = '" + id
					+ "'");
			while (result.next()) {
				// id INTEGER PRIMARY KEY AUTOINCREMENT, fullnames VARCHAR(50)
				// NOT NULL, department VARCHAR(20) stud_id integer not null
				details = "FullNames: " + result.getString(2) + " Dept: "
						+ result.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}

	public List<String> getallLects() {
		List<String> list = new ArrayList<String>();
		try {
			result = st.executeQuery("SELECT * FROM lecturer ");
			StringBuffer buf = new StringBuffer();
			while (result.next()) {
				buf.append(result.getInt(1) + ";" + result.getString(2) + ";"
						+ result.getString(3) + ";" + result.getString(4) + ";"
						+ result.getString(5) + ";" + result.getString(6) + ";"
						+ result.getString(7) + ";" + result.getString(8));
				list.add(buf.toString());
				buf.delete(0, buf.capacity());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public List<String> getLeturers(User stud) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		try {
			result = st
					.executeQuery("SELECT * FROM lecturer where id not in (select lect_id from evaluated where stud_id = "
							+ stud.getId() + ")");

			while (result.next()) {
				list.add(result.getInt(1) + ";" + result.getString(4) + ";"
						+ result.getString(8) + ";");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean addLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		boolean done = false;
		try {
			int ok = st
					.executeUpdate("INSERT INTO lecturer(username, password, fullnames, email, phone, Location, department) VALUES('"
							+ lecturer.getUsername()
							+ "','"
							+ lecturer.getPassword()
							+ "','"
							+ lecturer.getFullnames()
							+ "','"
							+ lecturer.getEmail()
							+ "','"
							+ lecturer.getPhone()
							+ "','"
							+ lecturer.getLocation()
							+ "','"
							+ lecturer.getDepart() + "') ");
			if (ok > 0)
				done = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return done;
	}

	public boolean evaluate(Lecturer lecturer, String evals, User stud) {
		// TODO Auto-generated method stub
		boolean updated = false;

		try {
			String pattern[] = evals.split(";");
			int update = st
					.executeUpdate("INSERT INTO evaluation(quest_id, eval, lect_id, stud_id ) VALUES('"
							+ pattern[0]
							+ "','"
							+ pattern[1]
							+ "','"
							+ lecturer.getId() + "','" + stud.getId() + "')");
			if (update > 0)
				updated = true;
			st.executeUpdate("insert into evaluated (lect_id, stud_id) values('"
					+ lecturer.getId() + "','" + stud.getId() + "')");

			st.executeUpdate("update lecturer set stud_id='" + stud.getId()
					+ "' where id = " + lecturer.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}

	public boolean addQuestion(Question quest) {
		// TODO Auto-generated method stub
		boolean done = false;
		try {
			int i = st.executeUpdate("INSERT INTO question(question) VALUES(\""
					+ quest.getQuestion() + "\")");
			if (i > 0)
				done = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return done;
	}

	public List<String> getQuestions() {
		// TODO Auto-generated method stub
		List<String> queries = new ArrayList<>();
		try {
			result = st.executeQuery("SELECT * FROM question");
			while (result.next()) {
				queries.add(result.getString(1) + " " + result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queries;
	}

	public boolean makeReport(List<String> results) {
		// TODO Auto-generated method stub
		boolean done = false;
		for (String report : results) {
			String values[] = report.split(";");
			try {
				int ok = st
						.executeUpdate("INSERT INTO report(lect_id, score, result, recommendation) VALUES('"
								+ values[0]
								+ "','"
								+ values[1]
								+ "','"
								+ values[2] + "','" + values[3] + "')");
				if (ok > 0)
					done = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return done;
	}

	public List<String> getReport(Lecturer lecturer) {
		// TODO Auto-generated method stub
		List<String> report = new ArrayList<>();
		try {// lect_id, score, result, recommendation
			result = st.executeQuery("SELECT * FROM report where lect_id = "
					+ lecturer.getId());
			while (result.next()) {
				report.add("Score: " + result.getString(3) + "\nResult: "
						+ result.getString(4) + "\nRecommendation: "
						+ result.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return report;
	}

	public Object getBalance(User stud) {
		List<String> list = new ArrayList<String>();
		try {
			result = st
					.executeQuery("SELECT * FROM lecturer where id is not (select lect_id from evaluated where stud_id = '"
							+ stud.getId() + "'");

			while (result.next()) {
				list.add(result.getInt(1) + ";" + result.getString(2) + ";"
						+ result.getString(3) + ";");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteLect(Lecturer lecturer) {
		boolean deleted = false;
		try {
			int update = st.executeUpdate("Delete from lecturer where id = "
					+ lecturer.getId());
			if (update > 0)
				deleted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted;
	}

	public List<String> getResults() {
		// TODO Auto-generated method stub
		// need to get the list of all lcturers from the db and use their id's
		// to
		// query for more.
		try {
			// get alist of all the lecturer ids from the database
			result = st.executeQuery("select id from lecturer");
			while (result.next()) {
				// try to perform another query as well.
				ResultSet set = st
						.executeQuery("select count(id) from evaluation where lect_id='"
								+ result.getInt(1) + "' and eval like '%YES%'");
				while (set.next()) {
					// http://stackoverflow.com/questions/13662984/creating-pie-charts-programmatically
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// returns yes values
		String sql = " select count(id) from evaluation where lect_id=1 and eval like '%YES%';";
		// returns the total number of evaluations for the lecturer.
		String sql1 = "select count(id) from evaluation where lect_id=1 ";

		return null;
	}
}