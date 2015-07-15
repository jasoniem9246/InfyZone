package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * The persistent class for the DEMO_USERS database table.
 * 
 */
@Entity
@Table(name="DEMO_USERS", schema="TESTUSER3")
@NamedQueries({
	@NamedQuery(name="DemoUser.findAll", query="SELECT d FROM DemoUser d"),
	@NamedQuery(name="DemoUser.findUserById", query="SELECT d FROM DemoUser d where d.userId = :userId"),
	@NamedQuery(name="DemoUser.getMaxID", query="select max(d.userId) from DemoUser d")	
})
public class DemoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMO_USERS_USERID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMO_USERS_USERID_GENERATOR")
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

	@Column(name="USER_EMAIL", length=30)
	private String userEmail;

	@Column(name="USER_NAME", length=100)
	private String userName;

	//bi-directional many-to-one association to DemoCustomer
	@OneToMany(mappedBy="demoUser")
	private List<DemoCustomer> demoCustomers = new LinkedList<DemoCustomer>();

	//bi-directional many-to-one association to DemoOrder
	@OneToMany(mappedBy="demoUser")
	private List<DemoOrder> demoOrders =  new LinkedList<DemoOrder>();

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

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<DemoCustomer> getDemoCustomers() {
		return this.demoCustomers;
	}

	public void setDemoCustomers(List<DemoCustomer> demoCustomers) {
		this.demoCustomers = demoCustomers;
	}

	public DemoCustomer addDemoCustomer(DemoCustomer demoCustomer) {
		getDemoCustomers().add(demoCustomer);
		demoCustomer.setDemoUser(this);

		return demoCustomer;
	}

	public DemoCustomer removeDemoCustomer(DemoCustomer demoCustomer) {
		getDemoCustomers().remove(demoCustomer);
		demoCustomer.setDemoUser(null);

		return demoCustomer;
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