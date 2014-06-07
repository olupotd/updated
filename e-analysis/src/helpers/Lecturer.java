package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lecturer {

	private SimpleDateFormat format;
	private String id;
	private String fullnames;
	private String depart;
	private String username, date_reg, Location, email, Phone, password;

	public Lecturer() {
		super();
		this.format = new SimpleDateFormat("dd/MM/YYYY");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate_reg() {
		return date_reg;
	}

	public void setDate_reg(Date date) {
		this.date_reg = format.format(date);
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullnames() {
		return fullnames;
	}

	public void setFullnames(String fullnames) {
		this.fullnames = fullnames;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
