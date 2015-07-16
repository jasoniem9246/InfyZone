import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import model.DemoUser;
import mytools.DBUtil;

import org.junit.Test;


public class DemoCustomerTest {

	@Test
	public void testDemoCustomer() {
		DemoCustomer cust = new DemoCustomer();
		assertEquals("model.DemoCustomer", cust.getClass().getName());
	}


	@Test
	public void testGetCustomerId() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustomerId(), (long)1);
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testSetCustomerId() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustomerId((long)100);
				assertEquals(cust.getCustomerId(), (long)100);
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testGetCreditLimit() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(1000);
				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCreditLimit(), bd);
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testSetCreditLimit() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				BigDecimal bd = new BigDecimal(500);
				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCreditLimit(bd);
				assertEquals(cust.getCreditLimit(), bd);
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testGetCustCity() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustCity(), "Sterling");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testSetCustCity() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustCity("Los Angeles");
				assertEquals(cust.getCustCity(), "Los Angeles");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
				
			}
	}

	@Test
	public void testGetCustFirstName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustFirstName(), "John");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}
	}

	@Test
	public void testSetCustFirstName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustFirstName("Jack");
				assertEquals(cust.getCustFirstName(), "Jack");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}
	}

	@Test
	public void testGetCustLastName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustLastName(), "Dulles");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}		
	}

	@Test
	public void testSetCustLastName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustLastName("Jason");
				assertEquals(cust.getCustLastName(), "Jason");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}		
	}

	@Test
	public void testGetCustPostalCode() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustPostalCode(), "20166");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}			
	}

	@Test
	public void testSetCustPostalCode() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustPostalCode("12321");
				assertEquals(cust.getCustPostalCode(), "12321");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}		

	}

	@Test
	public void testGetCustState() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getCustState(), "VA");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}		
		}

	@Test
	public void testSetCustState() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setCustState("CA");
				assertEquals(cust.getCustState(), "CA");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}
		}
	

	@Test
	public void testGetCustStreetAddress1() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)5);
				assertEquals(cust.getCustStreetAddress1(), "Hangar Center");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}		
	}

	@Test
	public void testSetCustStreetAddress1() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)5);
				cust.setCustStreetAddress1("JAVA Junction");
				assertEquals(cust.getCustStreetAddress1(), "JAVA Junction");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}
	}

	@Test
	public void testGetCustStreetAddress2() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)5);
				assertEquals(cust.getCustStreetAddress2(), "Third Floor");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testSetCustStreetAddress2() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)5);
				cust.setCustStreetAddress2("Gaithersburg");
				assertEquals(cust.getCustStreetAddress2(), "Gaithersburg");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testGetPhoneNumber1() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getPhoneNumber1(), "703-555-2143");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testSetPhoneNumber1() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setPhoneNumber2("911");
				assertEquals(cust.getPhoneNumber2(), "911");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testGetPhoneNumber2() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				assertEquals(cust.getPhoneNumber2(), null);
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testSetPhoneNumber2() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {

				DemoCustomer cust = em.find(DemoCustomer.class, (long)1);
				cust.setPhoneNumber2("110");
				assertEquals(cust.getPhoneNumber2(), "110");
			
			}
			catch(Exception e)
			{
				fail(e.getMessage());
				fail("Not yet implemented");
			} finally
			{
				em.close();
			}	
	}

	@Test
	public void testGetDemoUser() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			
			DemoCustomer cust = (DemoCustomer) em.createNamedQuery("DemoCustomer.findCustomerById").setParameter("customerId",1L).getSingleResult();
			assertNotNull(cust.getDemoUser());
			
			
			
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			fail("Not yet implemented");
		} finally
		{
			em.close();
			
		}
	}









	@Test
	
	public void testSetDemoUser() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    
		try {
				
					long maxID = (Long) em.createNamedQuery("DemoUser.getMaxID").getSingleResult() + 1l;
					DemoUser user = new DemoUser();
					user.setUserId(maxID);
					DemoCustomer cust = new DemoCustomer();
					cust.setDemoUser(user);
					assertEquals(cust.getDemoUser().getUserId(), maxID);
			
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			fail("Not yet implemented");
		} finally
		{
			em.close();
		}

	}

	@Test
	public void testGetDemoOrders() {
				EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
				try {
					
					DemoCustomer cust = (DemoCustomer) em.createNamedQuery("DemoCustomer.findCustomerById").setParameter("customerId",(long)1).getSingleResult();
					assertNotNull(cust.getDemoOrders());
					
					
				}
				catch(Exception e)
				{
					fail(e.getMessage());
					fail("Not yet implemented");
				} finally
				{
					em.close();
				}
	}

	@Test
	public void testSetDemoOrders() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
	    LinkedList orders = new LinkedList<DemoOrderItem>();

		try {
					BigDecimal bd = new BigDecimal(5000);
					DemoCustomer cust = new DemoCustomer();
					DemoOrder order = new DemoOrder();
					long maxID = (Long) em.createNamedQuery("DemoCustomer.getMaxID").getSingleResult() + 1l;
					cust.setCustomerId(maxID);
					cust.setCustFirstName("Bill");
					cust.setCustLastName("Gates");
					cust.setCustStreetAddress1(null);
					cust.setCustStreetAddress2(null);
					cust.setCustCity("Seattle");
					cust.setCustState("WA");
					cust.setCustPostalCode("12345");
					cust.setPhoneNumber1(null);
					cust.setPhoneNumber2(null);
					cust.setCreditLimit(bd);
					cust.setDemoUser(null);
					cust.setDemoOrders(orders);					
					trans.begin();
					em.persist(cust);
					trans.commit();
					DemoCustomer dbcust = (DemoCustomer) em.createNamedQuery("DemoCustomer.findCustomerById").setParameter("customerId", maxID).getSingleResult();
					assertEquals(dbcust.getDemoOrders().size(), 0);
			
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			fail("Not yet implemented");
		} finally
		{
			em.close();
			
		}
	}

	@Test
	public void testAddDemoOrder() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {

			
			DemoCustomer cust = new DemoCustomer();
			DemoOrder order = new DemoOrder();
			order = em.find(DemoOrder.class, (long)1);
			cust.addDemoOrder(order);
			assertNotNull(cust.getDemoOrders());
			
			
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			fail("Not yet implemented");
		} finally
		{
			em.close();
			
		}
	}

	@Test
	public void testRemoveDemoOrder() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			DemoCustomer cust = new DemoCustomer();
			DemoOrder order = new DemoOrder();
			cust.addDemoOrder(order);;
			cust.removeDemoOrder(order);
			assertEquals(cust.getDemoOrders().size(), 0);
			
			
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			fail("Not yet implemented");
		} finally
		{
			em.close();
			
		}
	}

}
