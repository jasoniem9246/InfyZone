import static org.junit.Assert.*;

import javax.persistence.EntityManager;






import model.DemoOrder;
import model.DemoUser;
import mytools.DBUtil;

import org.junit.Test;




public class ShowOrderHistoryAdminTest {

	@Test
	public void test() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try{
			DemoUser adminuser = em.find(DemoUser.class, 2l);
			assertEquals("N" ,adminuser.getAdminUser());
		}catch(Exception e){
			fail("Not yet implemented"+e.getMessage());
		}
		
	}

}
