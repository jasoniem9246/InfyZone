

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DemoCustomer;
import model.DemoUser;
/**
 * Servlet implementation class SetCustomerInfo
 */
@WebServlet("/SetCustomerInfo")
public class SetCustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCustomerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Hello WOrld");

		HttpSession session = request.getSession();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phoneNumber_1 = request.getParameter("phone1");
		String phoneNumber_2 = request.getParameter("phone2");
		String addressLine_1 = request.getParameter("address1");
		String addressLine_2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	//	HttpSession session = request.getSession();
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		trans.begin();
		
		try
		{
			DemoCustomer cust= new DemoCustomer();
			DemoUser user = (DemoUser) session.getAttribute("user");
			/*Setting the Customer Information coming in from EDIT PROFILE*/

		
			if(user != null)	
			{
				cust.setCustFirstName(firstName);
				cust.setCustLastName(lastName);
				cust.setCustStreetAddress1(addressLine_1);
				cust.setCustStreetAddress2(addressLine_2);
				cust.setPhoneNumber1(phoneNumber_1);
				cust.setPhoneNumber2(phoneNumber_2);
				cust.setCustCity(city);
				cust.setCustState(state);
				cust.setCustPostalCode(zipCode);
				
				/*setting the username, UserEmail, UserPassword in DemoUser first and then passing the object in DemoCustomer*/
				user.setUserName(userName);
				user.setUserEmail(email);
				user.setPassword(password);
				List<DemoCustomer> custs = user.getDemoCustomers();
				custs.add(cust);
				user.setDemoCustomers(custs);
				cust.setDemoUser(user);
		
				em.persist(cust);
				em.persist(em.merge(user));
				
				trans.commit();
			}

			if(user != null)
			{
				cust.setCustFirstName(firstName);
				cust.setCustLastName(lastName);
				cust.setCustStreetAddress1(addressLine_1);
				cust.setCustStreetAddress2(addressLine_2);
				cust.setPhoneNumber1(phoneNumber_1);
				cust.setPhoneNumber2(phoneNumber_2);
				cust.setCustCity(city);
				cust.setCustState(state);
				cust.setCustPostalCode(zipCode);
				
				/*setting the username, UserEmail, UserPassword in DemoUser first and then passing the object in DemoCustomer*/
				user.setUserName(userName);
				user.setUserEmail(email);
				user.setPassword(password);
				List<DemoCustomer> custs = user.getDemoCustomers();
				custs.add(cust);
				user.setDemoCustomers(custs);
				cust.setDemoUser(user);
				
				em.persist(cust);
				em.persist(user);
				
				trans.commit();
			}
				

		}
		catch(Exception e)
		{
			System.out.println();
		}
		finally
		{
			em.close();
		}
		
		getServletContext().getRequestDispatcher("/MainController").forward(request, response);
	}
}
