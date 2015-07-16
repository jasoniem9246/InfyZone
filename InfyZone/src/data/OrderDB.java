package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DemoOrder;

public class OrderDB {
	public static void addOrder(DemoOrder order) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			em.persist(order);
			em.flush();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			em.close();
		}
	}
}
