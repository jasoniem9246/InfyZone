

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoUser;
import mytools.DBUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DemoOrderTest {
	
	private EntityManager em;
	private EntityTransaction trans;
	private BigDecimal total;
	private DemoOrderItem orderItem;
	private List<DemoOrderItem> orderItems;
	private DemoUser user;
	private DemoCustomer cust;
	
	@Before
	public void setUp() {
		em = DBUtil.getEmFactory().createEntityManager();
		trans = em.getTransaction();
		total = new BigDecimal(100);
		orderItem = em.find(DemoOrderItem.class, 1l);
		orderItems = new LinkedList<DemoOrderItem>();
		orderItems.add(orderItem);
		user = em.find(DemoUser.class, 1l);
		cust = em.find(DemoCustomer.class, 1l);
	}
	
	@After
    public void tearDown() {
        em.close();
    }

	@Test
	public void testDemoOrder() {
		DemoOrder order = new DemoOrder();
		assertEquals("model.DemoOrder", order.getClass().getName());
	}

	@Test
	public void testGetOrderId() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		assertEquals(order.getOrderId(), 1L);
	}

	@Test
	public void testSetOrderId() {
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(new Date());
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertEquals(dbOrder.getOrderId(), maxID);
	}

	@Test
	public void testGetOrderTimestamp() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dbDate = sdf.format(order.getOrderTimestamp());
		assertEquals(dbDate,"12-07-2015");
	}

	@Test
	public void testSetOrderTimestamp() {
		Date date = new Date();
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(date);
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertNotNull(dbOrder.getOrderTimestamp());
	}

	@Test
	public void testGetOrderTotal() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		assertEquals(order.getOrderTotal(), new BigDecimal(1890));
	}

	@Test
	public void testSetOrderTotal() {
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(new Date());
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertNotNull(dbOrder.getOrderTotal());
	}

	@Test
	public void testGetDemoCustomer() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		assertNotNull(order.getDemoCustomer());
	}

	@Test
	public void testSetDemoCustomer() {
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(new Date());
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertNotNull(dbOrder.getDemoCustomer());
	}

	@Test
	public void testGetDemoUser() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		assertNotNull(order.getDemoUser());
	}

	@Test
	public void testSetDemoUser() {
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(new Date());
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertNotNull(order.getDemoUser());
	}

	@Test
	public void testGetDemoOrderItems() {
		DemoOrder order = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", 1L).getSingleResult();
		assertNotNull(order.getDemoOrderItems());
	}

	@Test
	public void testSetDemoOrderItems() {
		DemoOrder order = new DemoOrder();
		long maxID = (Long) em.createNamedQuery("DemoOrder.getMaxID").getSingleResult() + 1l;
		order.setOrderId(maxID);
		order.setOrderTotal(total);
		order.setDemoOrderItems(orderItems);
		order.setDemoUser(user);
		order.setOrderTimestamp(new Date());
		order.setDemoCustomer(cust);
		trans.begin();
		em.persist(order);
		trans.commit();
		DemoOrder dbOrder = (DemoOrder) em.createNamedQuery("DemoOrder.findOrderById").setParameter("orderId", maxID).getSingleResult();
		assertNotNull(order.getDemoUser());
	}

	@Test
	public void testAddDemoOrderItem() {
		DemoOrder order = new DemoOrder();
		order.addDemoOrderItem(orderItem);
		assertNotNull(order.getDemoOrderItems());
	}

	@Test
	public void testRemoveDemoOrderItem() {
		DemoOrder order = new DemoOrder();
		order.addDemoOrderItem(orderItem);
		order.removeDemoOrderItem(orderItem);
		assertEquals(order.getDemoOrderItems().size(), 0);
	}

}
