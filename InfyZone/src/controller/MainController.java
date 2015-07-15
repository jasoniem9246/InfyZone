package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ProductDB;
import model.DemoProductInfo;
import model.DemoCustomer;
import model.DemoOrder;
import model.DemoOrderItem;
//import model.DemoState;
import model.DemoUser;
import data.ProductDB;
import data.UserDB;
/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
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
		
		String categoryName = request.getParameter("category"); /*get the category name from the drop down in index page*/ 
		String action = request.getParameter("action");
		//String productId = request.getParameter("productID");
		//String orderid = request.getParameter("orderId");
		//String addingproducttocart = request.getParameter("productID");
		
		
		System.out.println("Action: " + action);
		
		
		/*------------------------------------------------------------------------------------------*/
		/*When should we get all the products to display on the jsp*/
		
		if(action == null || action.equals(""))
		{
			HttpSession session = request.getSession();
			List<DemoProductInfo> products = data.ProductDB.GetAllProducts();

			if(session.getAttribute("categories") == null) {
				List<String> categories = ProductDB.GetAllCategories();
				System.out.println(categories.get(0));
				session.setAttribute("categories", categories);
			} 
		
			try
			{
				
				request.setAttribute("products", products);
				
				
			}
			catch(Exception e)
			{
				request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
			}
				
			getServletContext()
			.getRequestDispatcher("/index.jsp")
			.forward(request, response);
			
			
		}
		
		else
		{
			if(action != null)
			{
				List<DemoProductInfo> products = ProductDB.GetProductByProductName(action);
				
				try
				{
					request.setAttribute("products", products);
				}
				catch(Exception e)
				{
					request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
				}
				
				getServletContext()
				.getRequestDispatcher("/index.jsp")
				.forward(request, response);
			}
		}
		
		/*------------------------------------------------------------------------------------------*/
		/*When Category Selected, Retrieve information by Category Name*/
			
		if(categoryName != null)
		{
			List<DemoProductInfo> products = ProductDB.GetProductByProductCategory(categoryName);
			//HttpSession session = request.getSession();
			try
			{
				request.setAttribute("products", products);
			}
			catch(Exception e)
			{
				request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
			}
			
			getServletContext()
			.getRequestDispatcher("/index.jsp")
			.forward(request, response);
		}
	
	}
}
