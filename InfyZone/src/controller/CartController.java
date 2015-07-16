package controller;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import data.OrderDB;
import data.ProductDB;
import model.DemoOrder;
import model.DemoOrderItem;
import model.DemoProductInfo;
import model.DemoUser;

public class CartController {
	private String productID;
	private int quantity;
	

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public static DemoOrder createOrder(DemoUser user, String productID, String quantity) {
		System.out.println("id: " + productID);
		DemoProductInfo prod = ProductDB.GetSingleProductByProductId(productID);
		if(quantity == null)
		{
			quantity = "1";
		}
		BigDecimal bd = new BigDecimal(quantity);
		DemoOrderItem orderItem = new DemoOrderItem();
		//orderItem.setDiscountAmount(new BigDecimal(0));
		
		orderItem.setUnitPrice(prod.getListPrice());
		orderItem.setDemoProductInfo(prod);
		orderItem.setQuantity(bd);

		//save order 
		DemoOrder order = new DemoOrder();
		orderItem.setDemoOrder(order);
		order.setDemoUser(user);
		List<DemoOrderItem> orderItems = new LinkedList<DemoOrderItem>();
		orderItems.add(orderItem);
		order.setDemoOrderItems(orderItems);
		
		return order;
	}
	
	public static DemoOrder setProductIntoOrder(DemoOrder order, String productID, String quantity) {
		if(quantity == null)
		{
			quantity = "1";
		}
		DemoProductInfo prod = ProductDB.GetSingleProductByProductId(productID);
		List<DemoOrderItem> orderItems = order.getDemoOrderItems();
		BigDecimal bd = new BigDecimal(quantity);
		//stored new product
		DemoOrderItem orderItem = new DemoOrderItem();
		orderItem.setUnitPrice(prod.getListPrice());
		orderItem.setDemoProductInfo(prod);
		orderItem.setQuantity(bd);	
		orderItem.setDemoOrder(order);
		orderItems.add(orderItem);

		
		order.setDemoOrderItems(orderItems);
		
		return order;
	}
	
	public static DemoOrder updateOrder(DemoOrder order, String productID, String quantity) {
		if(quantity == null)
		{
			quantity = "1";
		}
		DemoProductInfo prod = ProductDB.GetSingleProductByProductId(productID);
		List<DemoOrderItem> orderItems = order.getDemoOrderItems();
		BigDecimal bd = new BigDecimal(quantity);
		for(DemoOrderItem orderItem : orderItems) {
			if(orderItem.getDemoProductInfo().getProductId() == prod.getProductId()) {
				orderItem.setQuantity(bd);
				break;
			}
		}
		order.setDemoOrderItems(orderItems);
		return order;
	}
	
}
