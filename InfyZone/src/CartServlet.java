
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CartController;
import data.OrderDB;
import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
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
		DemoUser user = (DemoUser) session.getAttribute("user");
		DemoCustomer cust = (DemoCustomer) session.getAttribute("cust");
		String productID = request.getParameter("productID");
		String quantity = request.getParameter("quantity");
		String action = request.getParameter("action");
		//check user login
		if(user != null) {
			DemoOrder order = (DemoOrder) session.getAttribute("order");
			if(order == null) {
				System.out.println("Creating Order...");
				order = CartController.createOrder(user, cust, productID, quantity);
			} else if(action != null && action.equals("update")) {
				System.out.println("Updating Order...");
				System.out.println("Quantity: " + quantity);
				System.out.println("Product ID: " + productID);
				order = CartController.updateOrder(order, productID, quantity);
			} else if(action != null && action.equals("checkout")) {
				if(order.getDemoOrderItems().size() == 0) {
					response.sendRedirect("login.jsp");
					return;
				}
				//get total order
				System.out.println("Checking out....");		
				//Check address is not empty
				if(cust.getCustStreetAddress1() == null || cust.getCustStreetAddress1().equals("")) {
					String message = "Please add address before checking out!";
					request.setAttribute("message", message);
					getServletContext()
					.getRequestDispatcher("/editprofile.jsp")
					.forward(request, response);
					return;
				}
				
			
				order = setOrderTotal(order);
				order.setOrderTimestamp(new Date());
				OrderDB.addOrder(order);
				session.removeAttribute("order");
				getServletContext()
				.getRequestDispatcher("/confirmation.jsp")
				.forward(request, response);	
				return;
		    } else if (action != null && action.equals("view")) {
		    	//do nothing
		    } else if (action != null && action.equals("delete")) {
		    	List<DemoOrderItem> items = order.getDemoOrderItems();
		    	for(DemoOrderItem item: items) {
		    		if(item.getDemoProductInfo().getProductId() == Long.parseLong(productID)) {
		    			items.remove(item);
		    			break;
		    		}
		    	}
		    	order.setDemoOrderItems(items);
			} else { System.out.println("Inserting new product");
				order = CartController.setProductIntoOrder(order, productID, quantity);
			}
			
			order = setOrderTotal(order);
			session.setAttribute("order", order);
			
			getServletContext()
			.getRequestDispatcher("/shopping_cart.jsp")
			.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	public DemoOrder setOrderTotal(DemoOrder order) {
		List<DemoOrderItem> items = order.getDemoOrderItems();
		double total = 0.0;
		for(DemoOrderItem item: items) {
			total += item.getUnitPrice().doubleValue() * item.getQuantity().doubleValue();
		}
		order.setOrderTotal(new BigDecimal(total));
		return order;
	}

}
