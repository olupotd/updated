package android_wrapper;

import helpers.Manager;
import helpers.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IOManager implements Runnable {

	List<User> users = new ArrayList<User>();
	ServerSocket server;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Manager man;
	User usr;

	public IOManager() {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(8008);
			man = new Manager();
			usr = new User();
			while (true) {
				System.out.println("Android Server started....");
				socket = server.accept();
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				Thread t = new Thread(this);
				// add the user to a list of logged in users.
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String authenticate() {
		String valid = null;
		boolean ok = man.authenticate(usr);
		if (ok)
			valid = "Successful";
		return valid;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String request = ois.readObject().toString();
			int ok = Integer.parseInt(request.substring(0, 1));
			switch (ok) {

			case 1:
				// authentication
				String[] cred = request.split(";");
				usr.setRegNo(cred[1]);
				usr.setStudentNo(cred[2]);
				String result = authenticate();
				oos.writeObject(result);
				oos.flush();
				break;
			case 2:
				// send list of lecturers

				break;
			case 3:
				// evaluate the lecturers

				break;
			case 4:
				// logout the user

				break;
			default:
				// Error trying something not allowed or supported.

				break;
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new IOManager();

	}
}
