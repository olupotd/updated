package tests;

import helpers.Contact;
import helpers.DBManager;
import helpers.Post;
import helpers.Research;
import helpers.Schedule;
import helpers.User;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDbOperations {

	DBManager man;
	User user;
	Post post;
	Schedule schedule;
	Research research;
	Contact contact;

	// ServletRunner sr = new ServletRunner();
	// sr.registerServlet( "myServlet", StatefulServlet.class.getName() );
	@Before
	public void setUp() throws Exception {
		contact = new Contact();
		man = new DBManager();
		user = new User();
		post = new Post();
		schedule = new Schedule();
		StringBuffer buf = new StringBuffer();
		buf.append("Welcome to my research and this buffer can hold more information than you could possibly imagine");
		// user.setContact("0774435155");
		// user.setEmail("olupotd@aol.com");
		// user.setFullnames("Olupot Douglas");
		user.setUsername("olupotd");
		user.setPassword("justin");
		// user.setLocation("Kampala");
		// Assert.assertTrue(man.registerUser(user));
		//Assert.assertTrue(man.registerUser(user));
		research = new Research();
		research.setDate_published(new Date());
		research.setResearch(buf.toString());
		research.setUser(user);
		research.setTopic("A Simple Headline today.");
		research.setDept("Surgery");
	}

	@Test
	public void testRegisterUser() {
		// Assert.assertTrue(man.registerUser(user));
	}

	@Test
	public void testgetSingle_post() {
		post.setId(1);
		//Assert.assertNotNull(man.getPost(post));
	}

	@Test
	public void testSchedules() {

	}

	@Test
	public void testLogin() {
		//Assert.assertTrue(man.authenticate(user).isValid());
		post.setPost("Nothing for good is good ");
		post.setUser(user);
		post.setHeadline("Welcome !!");
		post.setId(1);
		post.setDate_posted(new Date());
		// post.setId(1);
		post.addComments("What are you talking about dude.");
		//Assert.assertNotNull(man.createPost(post));
	}

	@Test
	public void testEditProfile() {
		//Assert.assertTrue(man.updateInfo(user));

	}

	@Test
	public void testAddPost() {
		// Assert.assertTrue(man.createPost(post));

	}

	@Test
	public void testloadPosts() {
		//Assert.assertNotNull(man.getPosts());
	}

	@Test
	public void test_getSchedule() {
		schedule.setDate_created(new Date());
		schedule.setDate_scheduled("25/05/1991");
		schedule.setDesc("Simple description");
		schedule.setTag("Welcome");
		Assert.assertTrue(man.authenticate(user).isValid());
		schedule.setUser(user);
		man.createSchedule(schedule);
		Assert.assertNotNull(man.getSchedule(user));
		for (String sche : man.getSchedule(user)) {
			System.out.println(sche);
		}
	}

	@Test
	public void testCreate_research() {
		Assert.assertTrue(man.createResearch(research));
	}

	@Test
	public void testGetResearch() {
		Assert.assertNotNull(man.getResearch(user));
	}

	@Test
	public void testContact() {
		contact.setEmail("olupotd@aol.com");
		contact.setMessage("I just wanted to know whether you guys give massages");
		contact.setNames("Olupot Douglas");
		contact.setPhone("+256774435155");
		//Assert.assertTrue(man.contact(contact));
	}
}
