package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


/**
 * The persistent class for the DEMO_CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="DEMO_CUSTOMERS", schema="TESTUSER3")
@NamedQueries({
	@NamedQuery(name="DemoCustomer.findAll", query="SELECT d FROM DemoCustomer d"),
	@NamedQuery(name="DemoCustomer.findCustomerById", query="SELECT d FROM DemoCustomer d where d.customerId = :customerId"),
	@NamedQuery(name="DemoCustomer.getMaxID", query="select max(d.customerId) from DemoCustomer d")
})
public class DemoCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="DEMO_CUSTOMERS_CUSTOMERID_GENERATOR" )
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMO_CUSTOMERS_CUSTOMERID_GENERATOR")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID", unique=true, nullable=false)
	private long customerId;

	@Column(name="CREDIT_LIMIT", precision=9, scale=2)
	private BigDecimal creditLimit;

	@Column(name="CUST_CITY", length=30)
	private String custCity;

	@Column(name="CUST_FIRST_NAME", nullable=false, length=20)
	private String custFirstName;

	@Column(name="CUST_LAST_NAME", nullable=false, length=20)
	private String custLastName;

	@Column(name="CUST_POSTAL_CODE", length=10)
	private String custPostalCode;

	@Column(name="CUST_STATE", length=2)
	private String custState;

	@Column(name="CUST_STREET_ADDRESS1", length=60)
	private String custStreetAddress1;

	@Column(name="CUST_STREET_ADDRESS2", length=60)
	private String custStreetAddress2;

	@Column(name="PHONE_NUMBER1", length=25)
	private String phoneNumber1;

	@Column(name="PHONE_NUMBER2", length=25)
	private String phoneNumber2;

	//bi-directional many-to-one association to DemoUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private DemoUser demoUser;

	//bi-directional many-to-one association to DemoOrder
	@OneToMany(mappedBy="demoCustomer", cascade = CascadeType.PERSIST)
	private List<DemoOrder> demoOrders = new LinkedList<DemoOrder>();

	public DemoCustomer() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCustCity() {
		return this.custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustFirstName() {
		return this.custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return this.custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustPostalCode() {
		return this.custPostalCode;
	}

	public void setCustPostalCode(String custPostalCode) {
		this.custPostalCode = custPostalCode;
	}

	public String getCustState() {
		return this.custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustStreetAddress1() {
		return this.custStreetAddress1;
	}

	public void setCustStreetAddress1(String custStreetAddress1) {
		this.custStreetAddress1 = custStreetAddress1;
	}

	public String getCustStreetAddress2() {
		return this.custStreetAddress2;
	}

	public void setCustStreetAddress2(String custStreetAddress2) {
		this.custStreetAddress2 = custStreetAddress2;
	}

	public String getPhoneNumber1() {
		return this.phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public DemoUser getDemoUser() {
		return this.demoUser;
	}

	public void setDemoUser(DemoUser demoUser) {
		this.demoUser = demoUser;
	}

	public List<DemoOrder> getDemoOrders() {
		return this.demoOrders;
	}

	public void setDemoOrders(List<DemoOrder> demoOrders) {
		this.demoOrders = demoOrders;
	}

	public DemoOrder addDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().add(demoOrder);
		demoOrder.setDemoCustomer(this);

		return demoOrder;
	}

	public DemoOrder removeDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().remove(demoOrder);
		demoOrder.setDemoCustomer(null);

		return demoOrder;
	}

}