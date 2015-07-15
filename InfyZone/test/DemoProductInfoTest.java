import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import mytools.DBUtil;

import org.junit.Test;


public class DemoProductInfoTest {

@Test
	public void testDemoProductInfo() {
	DemoProductInfo products = new DemoProductInfo();
	assertEquals("model.DemoProductInfo", products.getClass().getName());
	}

	
	@Test
	public void testGetProductId() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getProductId(), (long)9);
			
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
	public void testSetProductId() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setProductId((long)25);
				assertEquals(products.getProductId(), (long)25);
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
	public void testGetCategory() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getCategory(), "Mens");
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
	public void testSetCategory() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setCategory("Face");
				assertEquals(products.getCategory(), "Face");
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
	public void testGetFilename() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getFilename(), "shoes.jpg");
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
	public void testSetFilename() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
			products.setFilename("Face.JPG");
			assertEquals(products.getFilename(), "Face.JPG");
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
	public void testGetImageLastUpdate() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Calendar calendar = new GregorianCalendar(2015,6,10);
			Date date = calendar.getTime();
			DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
			assertEquals(products.getImageLastUpdate(), date);
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
	public void testSetImageLastUpdate() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
			Calendar calendar = new GregorianCalendar(2015,10,21);
			Date date = calendar.getTime();
			products.setImageLastUpdate(date);
			assertEquals(products.getImageLastUpdate(), date);
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
	public void testGetListPrice() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(110);
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getListPrice(), bd);
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
	public void testSetListPrice() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				BigDecimal bd = new BigDecimal(200);
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setListPrice(bd);
				assertEquals(products.getListPrice(), bd);
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
	public void testGetMimetype() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getMimetype(), "image/jpeg");
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
	public void testSetMimetype() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setMimetype("jpg");
				assertEquals(products.getMimetype(), "jpg");
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
	public void testGetProductAvail() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getProductAvail(), "Y");
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
	public void testSetProductAvail() {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			try {
					DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
					products.setProductAvail("YES");
					assertEquals(products.getProductAvail(), "YES");
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
	public void testGetProductDescription() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getProductDescription(), "Leather upper and lower lace up shoes");
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
	public void testSetProductDescription() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setProductDescription("YES");
				assertEquals(products.getProductDescription(), "YES");
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
	public void testGetProductImage() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				byte[] b =	products.getProductImage();
	
				assertEquals(b.length, 1603);
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
	public void testSetProductImage() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				byte[] b = new byte[1700];
				
				products.setProductImage(b);
				byte[] d = products.getProductImage();
				assertEquals(products.getProductImage(), d);
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
	public void testGetProductName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getProductName(), "Mens Shoes");
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
	public void testSetProductName() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setProductName("YES");
				assertEquals(products.getProductName(), "YES");
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
	public void testGetProductimageurl() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				assertEquals(products.getProductimageurl(), null);
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
	public void testSetProductimageurl() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				DemoProductInfo products = em.find(DemoProductInfo.class, (long)9);
				products.setProductimageurl("www.google.com");
				assertEquals(products.getProductimageurl(), "www.google.com");
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
	public void testGetDemoOrderItems() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			
			DemoProductInfo products = (DemoProductInfo) em.createNamedQuery("DemoProductInfo.findProductById").setParameter("productId",(long)1).getSingleResult();
			assertNotNull(products.getDemoOrderItems());
			
			
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
	public void testSetDemoOrderItems() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();

		try {
					BigDecimal bd = new BigDecimal(5000);
					DemoProductInfo product = new DemoProductInfo();
					long maxID = (Long) em.createNamedQuery("DemoProductInfo.getMaxID").getSingleResult() + 1l;
					product.setProductId(maxID);
					product.setProductName("Apple Watch");
					product.setProductDescription("Not Worth It !");
					product.setCategory("Accessories");
					product.setProductAvail("N");
					product.setListPrice(bd);
					product.setProductImage(null);
					product.setMimetype(null);
					product.setFilename(null);
					product.setImageLastUpdate(null);
					trans.begin();
					em.persist(product);
					trans.commit();
					DemoProductInfo dbproduct = (DemoProductInfo) em.createNamedQuery("DemoProductInfo.findProductById").setParameter("productId", maxID).getSingleResult();
					assertNotNull(dbproduct.getDemoOrderItems());
			
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
	public void testAddDemoOrderItem() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();


		try {

			
			DemoProductInfo product = new DemoProductInfo();
			DemoOrderItem orderItem = new DemoOrderItem();
			orderItem = em.find(DemoOrderItem.class, (long)1);
			product.addDemoOrderItem(orderItem);
			assertNotNull(product.getDemoOrderItems());
			
			
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
	public void testRemoveDemoOrderItem() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			DemoProductInfo product = new DemoProductInfo();
			DemoOrderItem orderItem = new DemoOrderItem();
			product.addDemoOrderItem(orderItem);
			product.removeDemoOrderItem(orderItem);
			assertEquals(product.getDemoOrderItems().size(), 0);
			
			
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
