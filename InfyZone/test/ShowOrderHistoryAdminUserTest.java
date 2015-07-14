import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import model.DemoOrder;
import model.DemoUser;
import mytools.DBUtil;

import org.junit.Test;


public class ShowOrderHistoryAdminUserTest {

	@Test
	public void test() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try{
			DemoOrder adminOrd = em.find(DemoOrder.class, 3l);
			assertEquals(1 ,adminOrd.getDemoUser().getUserId());
		}catch(Exception e){
			fail("Not yet implemented"+e.getMessage());
		}
		
	}

}
