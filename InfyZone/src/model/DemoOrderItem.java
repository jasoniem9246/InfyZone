package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DEMO_ORDER_ITEMS database table.
 * 
 */
@Entity
@Table(name="DEMO_ORDER_ITEMS", schema="TESTUSER3")
@NamedQuery(name="DemoOrderItem.findAll", query="SELECT d FROM DemoOrderItem d")
public class DemoOrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMO_ORDER_ITEMS_ORDERITEMID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMO_ORDER_ITEMS_ORDERITEMID_GENERATOR")
	@Column(name="ORDER_ITEM_ID", unique=true, nullable=false, precision=3)
	private long orderItemId;

	@Column(nullable=false, precision=8)
	private BigDecimal quantity;

	@Column(name="UNIT_PRICE", nullable=false, precision=8, scale=2)
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to DemoOrder
	@ManyToOne
	@JoinColumn(name="ORDER_ID", nullable=false)
	private DemoOrder demoOrder;

	//bi-directional many-to-one association to DemoProductInfo
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private DemoProductInfo demoProductInfo;

	public DemoOrderItem() {
	}

	public long getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public DemoOrder getDemoOrder() {
		return this.demoOrder;
	}

	public void setDemoOrder(DemoOrder demoOrder) {
		this.demoOrder = demoOrder;
	}

	public DemoProductInfo getDemoProductInfo() {
		return this.demoProductInfo;
	}

	public void setDemoProductInfo(DemoProductInfo demoProductInfo) {
		this.demoProductInfo = demoProductInfo;
	}

}