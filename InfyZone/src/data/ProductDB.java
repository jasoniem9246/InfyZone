package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.DemoProductInfo;
//import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
//import model.DemoState;
//import model.DemoUser;

public class ProductDB {
	public static List<DemoProductInfo> GetAllProducts() {

		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from DemoProductInfo p";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString,
				DemoProductInfo.class);

		List<DemoProductInfo> i = null;

		try {
			i = q.getResultList();
			if (i == null || i.isEmpty()) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

	public static List<String> GetAllCategories() {

		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select distinct p.category from DemoProductInfo p";
		TypedQuery<String> q = em.createQuery(qString, String.class);

		List<String> i = null;

		try {
			i = q.getResultList();
			i.add("All");

			if (i == null || i.isEmpty()) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

	public static List<DemoProductInfo> GetProductByProductId(String productid) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from DemoProductInfo p where p.productId = :productid";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString,
				DemoProductInfo.class);
		q.setParameter("productid", Long.parseLong(productid));
		List<DemoProductInfo> i = null;

		try {
			i = q.getResultList();
			if (i == null || i.isEmpty()) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	public static List<DemoProductInfo> GetProductByProductNameAndCategory(String productName, String category) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "select p from DemoProductInfo p where upper(p.productName) like :productName and p.category = :category";
		List<DemoProductInfo> products;
		try {
			products = (List<DemoProductInfo>) em
					.createQuery(qString)
					.setParameter("productName", "%" + productName.toUpperCase() + "%")
					.setParameter("category", category).getResultList();
			return products;
		} catch (NoResultException e) {
			products = null;
		} finally {
			em.close();
		}

		return products;
	}

	public static List<DemoProductInfo> GetProductByProductName(String productName) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from DemoProductInfo p where p.productName = :productName";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString,
				DemoProductInfo.class);
		q.setParameter("productName", productName);
		List<DemoProductInfo> i = null;

		try {
			i = q.getResultList();
			if (i == null || i.isEmpty()) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

	public static List<DemoProductInfo> GetProductByProductCategory(
			String categoryname) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from DemoProductInfo p where p.category = :categoryname";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString,
				DemoProductInfo.class);
		q.setParameter("categoryname", categoryname);
		List<DemoProductInfo> i = null;

		try {
			i = q.getResultList();
			if (i == null || i.isEmpty()) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

	public static DemoProductInfo GetSingleProductByProductId(String productID) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from DemoProductInfo p where p.productId = :productID";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString, DemoProductInfo.class);
		q.setParameter("productID", Long.parseLong(productID));
		DemoProductInfo i = null;

		try {
			i = q.getSingleResult();
			if (i == null) {
				i = null;
			}
		} catch (NoResultException e) {
			System.out.println(e);
		}

		finally {
			em.close();
		}
		return i;
	}

}
