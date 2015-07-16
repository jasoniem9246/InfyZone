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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		List<DemoProductInfo> products = null;
		
		if(action == null || action.equals(""))
		{
			HttpSession session = request.getSession();
			products = data.ProductDB.GetAllProducts();

			//To show categories into selection list, check whether categories in session. If categories are not in session, then get those from db. 
			//We also add 'All' into categories after getting all categories from db. 
			if(session.getAttribute("categories") == null) {
				List<String> categories = ProductDB.GetAllCategories();
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
						
		} else if (action.equals("search")) {
			String category = request.getParameter("category");
			String productName = request.getParameter("productName");

			if (!productName.equals("") && productName != null) {
				if (category.equals("All")) {
					products = ProductDB.GetProductByProductName(productName);
				} else {
					products = ProductDB.GetProductByProductNameAndCategory(
							productName, category);
				}

			} else {
				if (category.equals("All")) {
					products = data.ProductDB.GetAllProducts();
				} else {
				products = ProductDB.GetProductByProductCategory(category);
				}
			}
			
			request.setAttribute("products", products);
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);

		} else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
}
