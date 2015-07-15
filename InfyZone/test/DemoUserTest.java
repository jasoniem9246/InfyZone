import model.DemoUser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;




import javax.persistence.EntityManager;

import model.DemoUser;
import mytools.DBUtil;

import org.junit.Test;

public class DemoUserTest {

	@Test
	public void testDemoUser() {
		DemoUser user = new DemoUser();
		assertEquals("model.DemoUser",user.getClass().getName());
	}

	@Test
	public void testGetUserId() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = (DemoUser) em.createQuery("Select d from DemoUser d where d.userId = :userId ").setParameter("userId", 1).getSingleResult();
		assertEquals(1l,user.getUserId());
		
	}
		

	@Test
	public void testSetUserId() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		user.setUserId(1l);
		assertEquals(1l,user.getUserId()); 
	}

	@Test
	public void testGetAdminUser() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = (DemoUser) em.createQuery("Select d from DemoUser d where d.adminUser = :adminUser ").setParameter("adminUser", "Y").getSingleResult();
		assertEquals("Y",user.getAdminUser());
	}

	@Test
	public void testSetAdminUser() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		user.setAdminUser("adminUser");
		
	}

	@Test
	public void testGetCreatedOn() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		GregorianCalendar gregDateFromDB = new GregorianCalendar(2015, 6, 13);
		Date dateFromDB = gregDateFromDB.getTime();
		
		long userId = 1;
		DemoUser testuser = DemoUserTest.getDemoUserById(userId);
		
		try{
			assertEquals(dateFromDB, testuser.getCreatedOn());
		}
		catch(Exception e){
			fail("Not yet implemented"+e);
		}
		
		
	}

	@Test
	public void testSetCreatedOn() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		GregorianCalendar gregChangeToDate = new GregorianCalendar(2015, 7, 13);
		Date setToObjectDate = gregChangeToDate.getTime();
		
		long userId = 1;
		DemoUser testUser = DemoUserTest.getDemoUserById(userId);
		testUser.setCreatedOn(setToObjectDate);
		Date createDate = testUser.getCreatedOn();
		try{
			assertEquals(testUser.getCreatedOn(), setToObjectDate);
		}
		catch(Exception e){
			fail("Not yet implemented"+e);
		}
	
		
	}

	@Test
	public void testGetExpiresOn() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		GregorianCalendar gregDateFromDB = new GregorianCalendar();
		Date dateFromDB = gregDateFromDB.getTime();
		
		long userId = 1;
		DemoUser testuser = DemoUserTest.getDemoUserById(userId);
		
		try{
			assertNull(dateFromDB, testuser.getCreatedOn());
			
		}
		catch(Exception e){
			fail("Not yet implemented"+e);
		}
	}

	private void assertNull(Date dateFromDB, Date createdOn) {}
		// TODO Auto-generated method stub
		
	

	@Test
	public void testSetExpiresOn() {
		
		DateFormat dateFormat = DateFormat.getDateInstance();
		GregorianCalendar gregChangeToDate = new GregorianCalendar();
		Date setToObjectDate = gregChangeToDate.getTime();
		
		long userId = 1;
		DemoUser testUser = DemoUserTest.getDemoUserById(userId);
		testUser.setCreatedOn(setToObjectDate);
		Date expiryDate = testUser.getExpiresOn();
		try{
			assertNull(testUser.getExpiresOn(),setToObjectDate);
			
		}
		catch(Exception e){
			fail("Not yet implemented"+e);
		}
	
	}

	@Test
	public void testGetPassword() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = (DemoUser) em.createQuery("Select d from DemoUser d where d.password = :password ").setParameter("password", "C96C19BE1416C025AD1D0AF567C1BBE2").getSingleResult();
		assertEquals("C96C19BE1416C025AD1D0AF567C1BBE2",user.getPassword());
		
	}

	@Test
	public void testSetPassword() {
		EntityManager  em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		user.setPassword("password");
	}

	@Test
	public void testGetProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = (DemoUser)em.createQuery("Select d from DemoUser d where d.products = :products ").setParameter("products", "Y").setMaxResults(1).getSingleResult();
		assertEquals("Y",user.getProducts());
		
	}

	@Test
	public void testSetProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		user.setProducts("products");
	}

	@Test
	public void testGetQuota() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		BigDecimal bd = new BigDecimal(15000);
		DemoUser user = (DemoUser) em.createQuery("Select d from DemoUser d where d.quota = :quota ").setParameter("quota", 15000).getSingleResult();
		assertEquals(bd,user.getQuota());
	}

	@Test
	public void testSetQuota() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		BigDecimal bd = new BigDecimal(15000);
         user.setQuota(bd);
		
			}

	@Test
	public void testGetUserName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = (DemoUser) em.createQuery("Select d from DemoUser d where d.userName = :userName ").setParameter("userName", "ADMIN").getSingleResult();
		assertEquals("ADMIN",user.getUserName());
	}

	@Test
	public void testSetUserName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoUser user = new DemoUser();
		user.setUserName("userName");
	}

	

public static DemoUser getDemoUserById(long userId){
	
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	DemoUser user;
	
	try{
		
		user = em.find(DemoUser.class, userId);
		return user;
	}
	catch(Exception e){
		System.out.println("problem retrieving database"+e);
		return null;
	}
	finally{
		em.close();
	}
  }
}
