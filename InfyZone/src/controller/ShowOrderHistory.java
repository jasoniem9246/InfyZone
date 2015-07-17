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
import model.DemoUser;
import mytools.DBUtil;

/**
 * Servlet implementation class ShowOrderHistory
 */
@WebServlet("/ShowOrderHistory")
public class ShowOrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderHistory() {
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
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
         HttpSession session = request.getSession();
         DemoUser user = (DemoUser) session.getAttribute("user");
		 System.out.println("Order History - User:" + user.getUserId());

		 if(user == null) {
			 response.sendRedirect("/index.jsp");
		} else {
			String adminuser = user.getAdminUser();
			

			if (adminuser.equals("Y")) {
				@SuppressWarnings("unchecked")
				List<DemoOrder> orders = em.createQuery(
						"SELECT d FROM DemoOrder d").getResultList();
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("/order_history.jsp").forward(
						request, response);
			} else if (adminuser.equals("N")) {
								long id = user.getUserId();
				@SuppressWarnings("unchecked")
				List<DemoOrder> orders = (List<DemoOrder>) em.createQuery(
						"SELECT d FROM DemoOrder d WHERE d.demoUser.userId = :userId").setParameter("userId", id)
						.getResultList();
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("/order_history.jsp").forward(
						request, response);

			}
		}
	}

}
