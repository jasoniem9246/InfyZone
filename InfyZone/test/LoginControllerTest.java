import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DemoOrder;
import model.DemoUser;
import mytools.DBUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LoginControllerTest {
	
	private EntityManager em;
	private EntityTransaction trans;
	private DemoUser user;
	
	@Before
	public void setUp(){
		em = DBUtil.getEmFactory().createEntityManager();
		trans = em.getTransaction();
		user = em.find(DemoUser.class, 1l);
		
	}

	@After
    public void tearDown() {
        em.close();
    }
	
	@Test
	public void test() {
		DemoUser user = new DemoUser();
		assertEquals("model.DemoUser",user.getClass().getName());
	}
	
	@Test
	public void testGetPassword() {
		DemoUser pwd = (DemoUser) em.createNamedQuery("DemoUser.findUserByPassword").setParameter("password", "123456").getSingleResult();
		assertNotNull(pwd.getPassword());
	}

	@Test
	public void testSetPassword() {
	 DemoUser user = new DemoUser();
		long maxID = (Long) em.createNamedQuery("DemoUser.getMaxID").getSingleResult() + 1l;
		user.setUserId(maxID);
		String userEmail = "infy@gmail.com";
		String userName = "ADMIN";
		user.setUserEmail(userEmail);
		user.setUserName(userName);
		
		trans.begin();
		em.persist(user);
		trans.commit();
		DemoUser dbuser = (DemoUser) em.createNamedQuery("DemoUser.findUserById").setParameter("userId", maxID).getSingleResult();
		assertNotNull(user.getUserName());
	}

}