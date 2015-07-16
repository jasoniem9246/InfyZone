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
		DemoOrderItem orderitem = (DemoOrderItem) em.createNamedQuery("DemoOrderItem.findOrderItemById").setParameter("orderItemId", (long)15).getSingleResult();
		assertEquals(orderitem.getDemoOrder().getOrderId(), 3);
	}

	@Test
	public void testSetDemoOrder() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    
		try {
				
					long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
					DemoOrder order = new DemoOrder();
					order.setOrderId(maxID);
					DemoOrderItem orderitem = new DemoOrderItem();
					orderitem.setDemoOrder(order);
					assertEquals(orderitem.getDemoOrder().getOrderId(),maxID);
			
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
		DemoOrderItem orderitem = (DemoOrderItem) em.createNamedQuery("DemoOrderItem.findOrderItemById").setParameter("orderItemId", (long)15).getSingleResult();
		assertEquals(orderitem.getDemoProductInfo().getProductId(), 5);
	}

	@Test
	public void testSetDemoProductInfo() {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
		    
			try {
					
						long maxID = (Long) em.createNamedQuery("DemoProductInfo.getMaxID").getSingleResult() + 1l;
						DemoProductInfo product = new DemoProductInfo();
						product.setProductId(maxID);
						DemoOrderItem orderitem = new DemoOrderItem();
						orderitem.setDemoProductInfo(product);
						assertEquals(orderitem.getDemoProductInfo().getProductId(),maxID);
				
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
