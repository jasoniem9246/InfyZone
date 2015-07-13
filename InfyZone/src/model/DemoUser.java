package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DEMO_USERS database table.
 * 
 */
@Entity
@Table(name="DEMO_USERS",schema="TESTUSER3")
@NamedQuery(name="DemoUser.findAll", query="SELECT d FROM DemoUser d")
public class DemoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", unique=true, nullable=false)
	private long userId;

	@Column(name="ADMIN_USER", length=1)
	private String adminUser;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRES_ON")
	private Date expiresOn;

	@Column(length=4000)
	private String password;

	@Column(length=1)
	private String products;

	@Column(name="\"QUOTA\"")
	private BigDecimal quota;

	@Column(name="USER_NAME", length=100)
	private String userName;

	//bi-directional many-to-one association to DemoOrder
	@OneToMany(mappedBy="demoUser")
	private List<DemoOrder> demoOrders;

	public DemoUser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getExpiresOn() {
		return this.expiresOn;
	}

	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProducts() {
		return this.products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public BigDecimal getQuota() {
		return this.quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<DemoOrder> getDemoOrders() {
		return this.demoOrders;
	}

	public void setDemoOrders(List<DemoOrder> demoOrders) {
		this.demoOrders = demoOrders;
	}

	public DemoOrder addDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().add(demoOrder);
		demoOrder.setDemoUser(this);

		return demoOrder;
	}

	public DemoOrder removeDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().remove(demoOrder);
		demoOrder.setDemoUser(null);

		return demoOrder;
	}

}