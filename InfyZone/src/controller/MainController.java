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
		String productId = request.getParameter("productID");
		String orderid = request.getParameter("orderId");
		String addingproducttocart = request.getParameter("productID");
		
		String newUserName, newCustomerEmailid, newCustomerPassword, oldUserName, oldUserPassword;
		newUserName = newCustomerEmailid = newCustomerPassword = oldUserName = oldUserPassword = null;
		
		
		
		
		/*------------------------------------------------------------------------------------------*/
		/*When should we get all the products to display on the jsp*/
		/*Ask Jason to check the variable names that he has used in his index.jsp - error with productID*/
		if(action == null || action.equals(""))
		{
			
			List<DemoProductInfo> products = data.ProductDB.GetAllProducts();
			
			List<String> categories = ProductDB.GetAllCategories();
			
			HttpSession session = request.getSession();
			try
			{
				request.setAttribute("products", products);
				request.setAttribute("categories", categories);
			}
			catch(Exception e)
			{
				request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
			}
				System.out.println("Hello WOrld");
			getServletContext()
			.getRequestDispatcher("/index.jsp")
			.forward(request, response);
			
			
		}
		
		else
		{
			if(action != null)
			{
				List<DemoProductInfo> products = ProductDB.GetProductByProductName(action);
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
		
		/*------------------------------------------------------------------------------------------*/
		/*When Category Selected, Retrieve information by Category Name*/
		/*	
		if(!categoryName.equals(null))
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
		
		
		/*------------------------------------------------------------------------------------------*/
		
		/*	
		if(action.equals("register"))
		{	
			/*New Customer Details*/
			/*Adding a new user - User Information we are adding are username, Email ID, Password*/
		/*	
			 newUserName = request.getParameter("name");
			 newCustomerEmailid = request.getParameter("email");
			 newCustomerPassword = request.getParameter("password");
			 if(!(newUserName.equals(null)) &&  !(newCustomerEmailid.equals(null)) && !(newCustomerPassword.equals(null)))
				{
					HttpSession session = request.getSession();
					
					UserDB.AddUser(newUserName, newCustomerEmailid, newCustomerPassword);
					
					List<DemoProductInfo> products = ProductDB.GetAllProducts();
					
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
		else
		{
			if(action.equals("login"))
			{
				
				/*Old Customer Detail Verification*/
				/*Verifying if the user exists - User Information verified are username and password*/
				/*Class Related - UserDB*/
		/*		oldUserName = request.getParameter("name");
				oldUserPassword = request.getParameter("password");
				
				List<DemoUser> user = UserDB.ValidateExistingUser(oldUserName, oldUserPassword); 
				
				if(!user.get(0).getUserName().equals(oldUserName) && !user.get(0).getPassword().equals(oldUserPassword))
				{
					HttpSession session = request.getSession();
					
					String urlPath = request.getParameter("previousURL");
					/*Checking for the previous page to redirect the user accordingly*/
					
						/*Redirect the user to index.jsp as he tried to directly login without choosing the product*/
		/*				List<DemoProductInfo> products = ProductDB.GetAllProducts();
						try
						{
							request.setAttribute("products", products);
						}
						catch(Exception e)
						{
							request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
						}
						
						
						getServletContext()
						.getRequestDispatcher(urlPath)
						.forward(request, response);
				}
					
				/*If the user fails to login redirect him to the login page*/
		/*		else
				{
					getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
				}
				
			}
		}
		
		 /*------------------------------------------------------------------------------------------*/		
		
		
		
		

		
		/*------------------------------------------------------------------------------------------*/
		/*Retrieve the products by product Id*/
		
		/*	if(! productId.equals(null))
		{
			List<DemoProductInfo> products = ProductDB.GetProductByProductId(productId);
			//HttpSession session = request.getSession();
			try
			{
				request.setAttribute("product", products);
			}
			catch(Exception e)
			{
				request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
			}
			
			getServletContext()
			.getRequestDispatcher("/product_detail.jsp")
			.forward(request, response);
		}
		
		/*------------------------------------------------------------------------------------------*/
		/*Order Detail */
		
		
		
		
		
		
		
		/*------------------------------------------------------------------------------------------*/
		/*Shopping cart module initiation - Add to cart initiated when no session variable available and productID parameter coming in 
		 * and getting stored in addingproducttocart in string form is not null*/
		/*	if((request.getSession(true) != null) && (! addingproducttocart.equals(null)))
		{
			AddToCart(request, response, addingproducttocart);
		}
		else
		{
			ViewCart(request, response);
		}
			
		/*------------------------------------------------------------------------------------------*/
		
	}
	
	
	
	
	/*protected  void AddToCart(HttpServletRequest request, HttpServletResponse response, String addingproducttocart)
	{
		request.setAttribute("addingProductToCart", addingproducttocart);
		
		
		try {
			getServletContext()
			.getRequestDispatcher("/AddToShoppingCart")
			.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected  void ViewCart(HttpServletRequest request, HttpServletResponse response)
	{
	//request.setAttribute("addingProductToCart", addingproducttocart);
		
		
		try {
			getServletContext()
			.getRequestDispatcher("/ViewCart")
			.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}

