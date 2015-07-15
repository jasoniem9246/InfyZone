

import java.text.NumberFormat;

import model.DemoProductInfo;
import data.Product;


public class LineItem {
	 private DemoProductInfo product;
	    private int quantity;

	    public LineItem() {}

	    public void setProduct(DemoProductInfo p) {
	        product = p;
	    }

	    public DemoProductInfo getProduct() {
	        return product;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public double getTotal() {
	        double total = product.getListPrice().doubleValue() * quantity;
	        return total;
	    }

	    public String getTotalCurrencyFormat() {
	        NumberFormat currency = NumberFormat.getCurrencyInstance();
	        return currency.format(this.getTotal());
	    }

}
