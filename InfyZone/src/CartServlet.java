

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DemoProductInfo;
import data.Cart;
import data.Product;
import data.ProductDB;
import data.LineItem;

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
		//HttpSession session = request.getSession();
		
ServletContext sc = getServletContext();
		
		String action = request.getParameter("action");
		if(action == null)
		{
			action = "cart";
		}
		
		String url = "/index.jsp";
		
		if(action.equals("shop"))
		{
			url = "/index.jsp";
		}
		
		else if(action.equals("cart"))
		{
			//String productCode = request.getParameter("productID");
			HttpSession session = request.getSession();
			
			String productID = (String) request.getAttribute("productID");
			String quantityString = request.getParameter("quantity");
			
			Cart cart = (Cart) session.getAttribute("cart");
			
			if(cart == null)
			{
				cart = new Cart();
			}
			
			int quantity;
			
			try
			{
				quantity = Integer.parseInt(quantityString);
				if(quantity < 0)
				{
					quantity = 1;
				}
				
			}
			catch(NumberFormatException e)
			{
				quantity = 1;
			}
			
	       //    String path = sc.getRealPath("/WEB-INF/products.txt");
	            DemoProductInfo product = ProductDB.GetSingleProductByProductId(productID);

	            LineItem lineItem = new LineItem();
	            lineItem.setProduct(product);;
	            lineItem.setQuantity(quantity);
	            if (quantity > 0) {
	                cart.addItem(lineItem);
	            } else if (quantity == 0) {
	                cart.removeItem(lineItem);
	            }

	            session.setAttribute("cart", cart);
	            url = "/cart.jsp";
		}
		
		 else if (action.equals("checkout")) {
	            url = "/checkout.jsp";
	        }

	        sc.getRequestDispatcher(url)
	                .forward(request, response);
		
	}

}
