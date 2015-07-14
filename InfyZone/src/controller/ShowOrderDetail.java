package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoUser;
import mytools.DBUtil;

/**
 * Servlet implementation class ShowOrderDetail
 */
@WebServlet("/ShowOrderDetail")
public class ShowOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderDetail() {
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
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
	    long id = Long.parseLong(request.getParameter("orderId")); 
	
			
			
		DemoOrder order = (DemoOrder) em.createQuery("SELECT d FROM DemoOrder d where d.orderId=:orderId").setParameter("orderId", id).getSingleResult();
		request.setAttribute("order", order);
		request.getRequestDispatcher("/order_detail.jsp").forward(
				request, response);
				
		
		
	}

}
