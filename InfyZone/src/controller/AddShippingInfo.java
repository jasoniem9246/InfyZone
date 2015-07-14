package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DemoCustomer;
import model.DemoUser;

/**
 * Servlet implementation class AddShippingInfo
 */
@WebServlet("/AddShippingInfo")
public class AddShippingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShippingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		long CustId = request.getParameter("customerId");
	
		
		String CustFirstName = request.getParameter("custFirstName");
		String CustLastName = request.getParameter("custLastName");
		String CustAddress1 = request.getParameter("custStreetAddress1");
		String CustAddress2 = request.getParameter("custStreetAddress2");
		String CustCity = request.getParameter("custCity");
		String CustState = request.getParameter("custState");
		String CustPostCode = request.getParameter("custPostalCode");
		String CustPhoneNumber = request.getParameter("phoneNumber1");
		String CustEmail = request.getParameter("custEmail");
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		
		try
		{
			
			
			DemoCustomer cust = new DemoCustomer();
//			cust.setCustomerId(customerId);(CustId);
			cust.setCustFirstName(CustFirstName);
			cust.setCustLastName(CustLastName);
			cust.setCustStreetAddress1(CustAddress1);
			cust.setCustStreetAddress2(CustAddress2);
			cust.setCustCity(CustCity);
			cust.setCustState(CustState);
			cust.setCustPostalCode(CustPostCode);
			cust.setPhoneNumber1(CustPhoneNumber);
			cust.setCustEmail(CustEmail);
			em.persist(cust);
			
			trans.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			trans.rollback();
		}
		finally
		{
			em.close();
		}
		
		getServletContext()
		.getRequestDispatcher("/confirmation.jsp")
		.forward(request, response);
	}


}
