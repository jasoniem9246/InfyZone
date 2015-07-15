

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CartController;
import data.ProductDB;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import model.DemoUser;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		HttpSession session = request.getSession();
		boolean loggedin = session.getAttribute("loggedin") != null ? true : false;
		DemoUser user = (DemoUser) session.getAttribute("user");
		String productID = request.getParameter("productID");
		String quantity = request.getParameter("quantity");
		//check user login
		if(user != null) {
			DemoOrder order = (DemoOrder) session.getAttribute("order");
			if(order != null) {
				order = CartController.setProductIntoOrder(order, productID, quantity);
			} else {
				order = CartController.createOrder(user, productID, quantity);
				System.out.println("create order");
			}
			
			System.out.println("Quantity: " + order.getDemoOrderItems().get(0).getQuantity());
			session.setAttribute("order", order);
			
			getServletContext()
			.getRequestDispatcher("/shopping_cart.jsp")
			.forward(request, response);
		}
		
		else
		{
			if(!loggedin)
			{
				response.sendRedirect("login.jsp");
			}
		}
	}

}
