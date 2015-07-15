package data;



import java.util.ArrayList;


public class Cart {
	 private ArrayList<LineItem> items;

	    public Cart() {
	        items = new ArrayList<LineItem>();
	    }

	    public ArrayList<LineItem> getItems() {
	        return items;
	    }

	    public int getCount() {
	        return items.size();
	    }

	    public void addItem(LineItem item) {
	        long code = item.getProduct().getProductId();
	        int quantity = item.getQuantity();
	        for (int i = 0; i < items.size(); i++) {
	            LineItem lineItem = items.get(i);
	            if (lineItem.getProduct().getProductId() == code) {
	                lineItem.setQuantity(quantity);
	                return;
	            }
	        }
	        items.add(item);
	    }

	    public void removeItem(LineItem item) {
	        long code = item.getProduct().getProductId();
	        for (int i = 0; i < items.size(); i++) {
	            LineItem lineItem = items.get(i);
	            if (lineItem.getProduct().getProductId() == code) {
	                items.remove(i);
	                return;
	            }
	        }
	    }

}