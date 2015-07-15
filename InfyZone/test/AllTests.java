import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ DemoOrderTest.class, DemoUserTest.class,
		ShowOrderHistoryAdminTest.class, 
		ShowOrderHistoryAdminUserTest.class
		 })
public class AllTests {

}
