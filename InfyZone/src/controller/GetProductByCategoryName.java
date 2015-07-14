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

/**
 * Servlet implementation class GetProductByCategoryId
 */
@WebServlet("/GetProductByCategoryName")
public class GetProductByCategoryName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductByCategoryName() {
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
		
		String tableInfo = "";
		String categoryName = request.getParameter("category");
		List<DemoProductInfo> productInfo = displayAllProductInfo(categoryName);
				
		try
		{
			
			tableInfo += tableInfo += "<tr><th>Product Name</th><th>Product Description</th><th>Price</th></tr>";
			for(int i = 0; i < productInfo.size(); i++)
			{
				
				tableInfo += "<tr><td>" + productInfo.get(i).getProductName()
						+ "</th><th>" + "<a href='displayProductDetail?productId="
						+ productInfo.get(i).getProductName() + "'>"
						+ "</th><th>" + productInfo.get(i).getProductDescription()
						+ "</th><th>" + productInfo.get(i).getListPrice()
						+ "</td></tr>";

			}
			request.setAttribute("tableInfo", tableInfo);
		}
		catch(Exception e)
		{
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error Happens for GetProductByCategoryName servlet! " + e + "</div>");
		}
		
		getServletContext()
		.getRequestDispatcher("/displayProductByCategory.jsp")
		.forward(request, response);
		
	}
	
	protected static List<DemoProductInfo> displayAllProductInfo(String categoryName)
	{
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d FROM DemoProductInfo d where d.category = :category";
		TypedQuery<DemoProductInfo> q = em.createQuery(qString, DemoProductInfo.class);
		q.setParameter("category", (categoryName));
		List<DemoProductInfo> i = null;
		try
		{
		
			i = q.getResultList();
			if(i == null || i.isEmpty())
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally 
		{
			em.close();
		}
		
		return i;

	}

}
