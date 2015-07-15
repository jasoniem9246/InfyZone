import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import mytools.DBUtil;

import org.junit.Test;


public class DemoOrderItemTest {

	@Test
	public void testDemoOrderItem() {
		DemoOrderItem orderitem = new DemoOrderItem();
		assertEquals("model.DemoOrderItem", orderitem.getClass().getName());
	}


	@Test
	public void testGetOrderItemId() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				assertEquals(orderitem.getOrderItemId(), (long)1);
			
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
	public void testSetOrderItemId() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				orderitem.setOrderItemId((long) 1000);
				assertEquals(orderitem.getOrderItemId(), (long)1000);
			
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
	public void testGetQuantity() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(10);
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				assertEquals(orderitem.getQuantity(), bd);
			
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
	public void testSetQuantity() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(666);
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				orderitem.setQuantity(bd);
				assertEquals(orderitem.getQuantity(), bd);
			
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
	public void testGetUnitPrice() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(50);
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				assertEquals(orderitem.getUnitPrice(), bd);
			
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
	public void testSetUnitPrice() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(10000);
				DemoOrderItem orderitem = em.find(DemoOrderItem.class, (long)1);
				orderitem.setUnitPrice(bd);
				assertEquals(orderitem.getUnitPrice(), bd);
			
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
	public void testGetDemoOrder() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoOrderItem orderitem = (DemoOrderItem) em.createNamedQuery("DemoOrderItem.findOrderItemById").setParameter("orderItemId", (long)1).getSingleResult();
		assertNotNull(orderitem.getDemoOrder());
	}

	@Test
	public void testSetDemoOrder() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();

		try {
					BigDecimal bd1 = new BigDecimal(5000);
					BigDecimal bd2 = new BigDecimal(100);
					DemoOrder order = new DemoOrder();
					DemoProductInfo product = new DemoProductInfo();
					DemoOrderItem orderitem = new DemoOrderItem();
					long maxID = (Long) em.createNamedQuery("DemoOrderItem.getMaxID").getSingleResult() + 1l;
					orderitem.setOrderItemId(maxID);
					orderitem.setDemoOrder(order);
					orderitem.setDemoProductInfo(product);
					orderitem.setUnitPrice(bd1);
					orderitem.setQuantity(bd2);
					trans.begin();
					em.persist(orderitem);
					trans.commit();
					DemoOrderItem dborder = (DemoOrderItem) em.createNamedQuery("DemoOrderItem.findOrderItemById").setParameter("orderItemId", maxID).getSingleResult();
					assertNotNull(dborder.getDemoOrder());
			
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
	public void testGetDemoProductInfo() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		DemoOrderItem orderitem = (DemoOrderItem) em.createNamedQuery("DemoOrderItem.findOrderItemById").setParameter("orderItemId", (long)1).getSingleResult();
		assertNotNull(orderitem.getDemoProductInfo());
	}

	@Test
	public void testSetDemoProductInfo() {
		fail("Not yet implemented");
	}

}
