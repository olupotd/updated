package helpers;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DbTest {
	User user;
	Manager man;
	Question quest;
	Lecturer lecturer;

	@Before
	public void setUp() throws Exception {
		lecturer = new Lecturer();
		man = new Manager();
		user = new User();
		user.setRegNo("admin");
		user.setStudentNo("admin");
		lecturer.setDate_reg(new Date());
		lecturer.setDepart("Networks");
		lecturer.setEmail("mnsabagwa@cis.mak.ac.ug");
		lecturer.setFullnames("Mary Nsabagwa");
		lecturer.setLocation("Kampala");
		lecturer.setUsername("msabagwa");

		Assert.assertTrue(man.addLecturer(lecturer));

		Assert.assertTrue(man.authenticate(user));

	}

	@Test
	public void testRegister() {
		user.setEmail("admin@cis.mak.ac.ug");
		user.setFullnames("Olupot Douglas");
		// Assert.assertTrue(man.register(user));
	}

	@Test
	public void testDeleteLect() {
		lecturer = new Lecturer();
		Assert.assertTrue(man.deleteLect(lecturer));
	}

	@Test
	public void testLogin() {
		// Assert.assertTrue(man.authenticate(user));
		System.out.println(user.getEmail() + " " + user.getFullnames());

	}

	@Test
	public void testAddQuestion() {
		quest = new Question();
		quest.setQuestion("Does your Lecturer have time for you outside class?");
		Assert.assertTrue(man.addQuestion(quest));
		quest.setQuestion("How do you grade their Performace in class?");
		Assert.assertTrue(man.addQuestion(quest));
		quest.setQuestion("Does your lecturer give you enough time for courseworks");
		Assert.assertTrue(man.addQuestion(quest));
	}

	@Test
	public void testAddLectr() {
		lecturer.setDepart("Networks");
		lecturer.setFullnames("Grace Kamulegeya");
		// Assert.assertTrue(man.addLecturer(lecturer));
	}

	@Test
	public void testGetLectr() {
		Assert.assertNotNull(man.getLeturers(user));
		for (String lect : man.getLeturers(user)) {
			System.out.println(lect);

		}
	}

	@Test
	public void testFetchAndEval() {
		System.out.println(user.getId());
		lecturer.setId("2");
		Assert.assertNotNull(man.getQuestions());
		for (String q : man.getQuestions()) {
			String id[] = q.split(" ");
			System.out.println(q + " " + id[0]);
			String eval = id[0] + ";" + "YES";
			Assert.assertTrue(man.evaluate(lecturer, eval, user));
		}
		Assert.assertNotNull(man.getLeturers(user));
		for (String lect : man.getLeturers(user)) {
			System.out.println(lect);

		}

	}

}
