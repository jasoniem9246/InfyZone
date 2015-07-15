package controller;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import data.ProductDB;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import model.DemoUser;

public class CartController {
	private String productID;
	private List<DemoProductInfo> products;
	private static List<DemoOrder> orderList;
	private int quantity;
	
	@PostConstruct
	public void init(){
		products = ProductDB.GetAllProducts();
		orderList = new LinkedList<DemoOrder>();
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public List<DemoProductInfo> getProducts() {
		return products;
	}

	public void setProducts(List<DemoProductInfo> products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public List<DemoOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<DemoOrder> orderList) {
		this.orderList = orderList;
	}
	
	public static DemoOrderItem createOrder(DemoUser user, String productID, String quantity) {
	
		DemoProductInfo prod = ProductDB.GetSingleProductByProductId(productID);
		
		//save order item
		if(quantity == null)
		{
			quantity = "0";
		}
		BigDecimal bd = new BigDecimal(quantity);
		DemoOrderItem orderItem = new DemoOrderItem();
		//orderItem.setDiscountAmount(new BigDecimal(0));
		orderItem.setUnitPrice(prod.getListPrice());
		orderItem.setDemoProductInfo(prod);
		orderItem.setQuantity(bd);
		
		
		
		//save order 
		DemoOrder order = new DemoOrder();
		order.setDemoUser(user);
		List<DemoOrderItem> orderItems = new LinkedList<DemoOrderItem>();
		orderItems.add(orderItem);
		order.setDemoOrderItems(orderItems);
		//System.out.println("1289y12");
		//save in order history
		System.out.println(order);
		orderList.add(order);
		
		return orderItem;
		//save orderItem into session
		//session.setAttribute("orderItem", orderItem);
	}
}
