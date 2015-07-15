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
		// TODO Auto-generated method stub
		doPost(request, response);
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
			 if(!(newUserName.equals(null)) &&  !(newCustomerEmailid.equals(null)) && !(newCustomerPassword.equals(null)))
				{
					HttpSession session = request.getSession();
					
					UserDB.AddUser(newUserName, newCustomerEmailid, newCustomerPassword);
					
					List<DemoProductInfo> products = ProductDB.GetAllProducts();
				
					DemoUser user = UserDB.GetUserByEmailAndPassword(newCustomerEmailid, newCustomerPassword);
					
					try
					{
						loggedin = true;
						request.setAttribute("products", products);
						session.setAttribute("loggedin", loggedin);
						session.setAttribute("user", user);
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
				String oldUserEmail = request.getParameter("email");
				String oldUserPassword = request.getParameter("password");
				
				List<DemoUser> user = UserDB.ValidateExistingUser(oldUserEmail, oldUserPassword); 
				
				if(user.get(0).getUserName().equals(oldUserEmail) && user.get(0).getPassword().equals(oldUserPassword))
				{
					HttpSession session = request.getSession();
					
					String urlPath = request.getParameter("previousURL");
					/*Checking for the previous page to redirect the user accordingly*/
					
						/*Redirect the user to index.jsp as he tried to directly login without choosing the product*/
						List<DemoProductInfo> products = ProductDB.GetAllProducts();
						try
						{
							loggedin = true;
							request.setAttribute("products", products);
							session.setAttribute("loggedin", loggedin);
							session.setAttribute("user", user.get(0));
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
				else
				{
					getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
				}
				
			}
		}
		
		
	}

}
