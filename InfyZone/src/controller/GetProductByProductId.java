package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DemoProductInfo;
import model.DemoProductInfo;
import data.ProductDB;
/**
 * Servlet implementation class GetProductByProductId
 */
@WebServlet("/GetProductByProductId")
public class GetProductByProductId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductByProductId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String productId = request.getParameter("productID");
		
			if(! productId.equals(null))
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
	}
	

}
