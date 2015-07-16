

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
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
import data.OrderDB;
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
		double total = 0.0;
		DemoUser user = (DemoUser) session.getAttribute("user");
		String productID = request.getParameter("productID");
		String quantity = request.getParameter("quantity");
		String action = request.getParameter("action");
		//check user login
		if(user != null) {
			DemoOrder order = (DemoOrder) session.getAttribute("order");
			if(order == null) {
				System.out.println("Creating Order...");
				order = CartController.createOrder(user, productID, quantity);
			} else if(action != null && action.equals("update")) {
				System.out.println("Updating Order...");
				System.out.println("Quantity: " + quantity);
				System.out.println("Product ID: " + productID);
				order = CartController.updateOrder(order, productID, quantity);
			} else if(action != null && action.equals("checkout")) {
				//get total order
				System.out.println("Checking out....");
				total = getOrderTotal(order);
				order.setOrderTotal(new BigDecimal(total));
				order.setOrderTimestamp(new Date());
				System.out.println("Total: " + total);
				OrderDB.addOrder(order);
				
				
				getServletContext()
				.getRequestDispatcher("/confirmation.jsp")
				.forward(request, response);
			
		    } else {
				System.out.println("Inserting new product");
				order = CartController.setProductIntoOrder(order, productID, quantity);
			}
			
			total = getOrderTotal(order);
			session.setAttribute("orderTotal", total);
			session.setAttribute("order", order);
			
			getServletContext()
			.getRequestDispatcher("/shopping_cart.jsp")
			.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	public double getOrderTotal(DemoOrder order) {
		List<DemoOrderItem> items = order.getDemoOrderItems();
		double total = 0.0;
		for(DemoOrderItem item: items) {
			total += item.getUnitPrice().doubleValue() * item.getQuantity().doubleValue();
		}
		return total;
	}

}
