package model;
import java.io.Serializable;
import java.util.Date;
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	public enum Status{
		REQUESTED,
		IN_PROGRESS,
		SENT,
		DELIVERED
	}
	private Date date;
	private Status status;
	private Product[] products;
	private int[] productAmounts;
	private User user;
	private Customer customer;
	public Order(Product[] products, int[] productAmounts, User user, Customer customer) {
		date = new Date();
		status = Status.REQUESTED;
		this.products = products;
		this.productAmounts = productAmounts;
		this.user = user;
		this.customer = customer;
	}
	public void updateStatus(){
		if (status == Status.REQUESTED)
			status = Status.IN_PROGRESS;
		else if (status == Status.IN_PROGRESS)
			status = Status.SENT;
		else if (status == Status.SENT)
			status = Status.DELIVERED;
	}
	public Date getDate() {
		return date;
	}
	public Product[] getProducts() {
		return products;
	}
	public int[] getProductAmounts() {
		return productAmounts;
	}
	public User getUser() {
		return user;
	}
	public Customer getCustomer() {
		return customer;
	}
}