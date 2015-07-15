package controller;

import java.io.IOException;
import java.math.BigDecimal;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoUser;

/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserID = request.getParameter("userId");
		String CustID = request.getParameter("customerId");
		String OrderID = request.getParameter("orderId");
		String OrderItemID = request.getParameter("orderItemId");
		String ProductID = request.getParameter("productId");
		String Unit_Price = request.getParameter("listPrice");
		String Quantity = request.getParameter("quantity");
		String Order_Total = request.getParameter("orderTotal");
		
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		
		try
		{
			BigDecimal bd1 = new BigDecimal(Quantity);
			BigDecimal bd2 = new BigDecimal(Unit_Price);
			BigDecimal bd3 = new BigDecimal(Order_Total);
			Calendar calendar = new GregorianCalendar();
			Date date = calendar.getTime();
			
			DemoOrder order = new DemoOrder();
			DemoOrderItem orderItem = new DemoOrderItem();
			
			orderItem.setQuantity(bd1);
			orderItem.setUnitPrice(bd2);
			
			
			order.setOrderTotal(bd3);
			order.setOrderTimestamp(date);
			
			em.persist(order);
			em.persist(orderItem);
			
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
