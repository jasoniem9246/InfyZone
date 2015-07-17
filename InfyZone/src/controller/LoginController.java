package controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserDB;
import data.ProductDB;
import model.DemoCustomer;
import model.DemoOrder;
import model.DemoProductInfo;
import model.DemoUser;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout user
		String action = request.getParameter("action");
		if(action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("MainController");
		} else {
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		boolean loggedin = false;
		if(action.equals("register"))
		{	
			/*New Customer Details*/
			/*Adding a new user - User Information we are adding are username, Email ID, Password*/
			
			String newUserName = request.getParameter("name");
			String newCustomerEmailid = request.getParameter("email");
			String newCustomerPassword = request.getParameter("password");
			 if(newUserName != null &&  newCustomerEmailid != null && newCustomerPassword != null )
				{
				 System.out.println("Registering...");
					HttpSession session = request.getSession();
					
					UserDB.AddUser(newUserName, newCustomerEmailid, newCustomerPassword);
					
					//List<DemoProductInfo> products = ProductDB.GetAllProducts();
					
					DemoCustomer cust = new DemoCustomer();
					//UserDB.AddUser(newUserName, newCustomerEmailid, newCustomerPassword);
					DemoUser user = UserDB.GetUserByEmailAndPassword(newCustomerEmailid, newCustomerPassword);
					System.out.println("User ID: " + user.getUserId());
					cust.setCustFirstName(" ");
					cust.setCustLastName(" ");
					cust.setDemoUser(user);
					UserDB.AddCustomer(cust);
					cust = UserDB.GetCustomerByUserID(user.getUserId());
					try
					{
						loggedin = true;
						
						session.setAttribute("loggedin", loggedin);
						session.setAttribute("user", user);
						session.setAttribute("cust", cust);
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
				
					response.sendRedirect("MainController");
				}
			
		}
		else
		{
			if(action.equals("login"))
			{
				
				/*Old Customer Detail Verification*/
				/*Verifying if the user exists - User Information verified are username and password*/
				/*Class Related - UserDB*/
				String oldUserEmail = request.getParameter("email");
				String oldUserPassword = request.getParameter("password");
				
				List<DemoUser> users = UserDB.ValidateExistingUser(oldUserEmail, oldUserPassword); 
				DemoUser user = null;
				
				// Checking the list returned is null
				if(users == null)
				{
					 user = null;
				}
				else
				{
					user = users.get(0);
				}
			
				
				if(user != null )
				{
					HttpSession session = request.getSession();
					System.out.println("User ID " + user.getUserId());
					DemoCustomer cust = UserDB.GetCustomerByUserID(user.getUserId());
					System.out.println("Cust ID " + cust.getCustomerId());
					String[] parsePreviousURL = request.getParameter("previousURL").split("/");
					
					String urlPath = parsePreviousURL[parsePreviousURL.length - 1];
					
					/*Checking for the previous page to redirect the user accordingly*/
					
						/*Redirect the user to index.jsp as he tried to directly login without choosing the product*/
						//List<DemoProductInfo> products = ProductDB.GetAllProducts();
						try
						{
							loggedin = true;
							//request.setAttribute("products", products);
							session.setAttribute("loggedin", loggedin);
							session.setAttribute("cust", cust);
							session.setAttribute("user", user);
						}
						catch(Exception e)
						{
							request.setAttribute("message", "<div class='alert alert-danger role='alert'>Error! Danger" + e + "</div>");
						}
						
						
						response.sendRedirect(urlPath);
				}
					
				/*If the user fails to login redirect him to the login page*/
				else
				{
					request.setAttribute("message", "Email or Password is not correct!");

					getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
				}
				
			}
		}
		
		
	}

}
