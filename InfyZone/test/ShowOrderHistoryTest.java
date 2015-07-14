import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import model.DemoOrder;

import org.junit.Test;


public class ShowOrderHistoryTest {

	@Test
	public void test() {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		List<DemoOrder> orderList = em.createNamedQuery("DemoOrder.findAll").getResultList();
		assertEquals(orderList.size(), 10);
	}

}
