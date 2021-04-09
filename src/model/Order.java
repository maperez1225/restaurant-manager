package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	private List<Product> products;
	private List<Integer> productAmounts;
	private User user;
	private Customer customer;
	public Order(User user, Customer customer) {
		date = new Date();
		status = Status.REQUESTED;
		products = new ArrayList<Product>();
		productAmounts = new ArrayList<Integer>();
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
	public void addProduct(Product product) {
		products.add(product);
	}
	public List<Product> getProducts() {
		return products;
	}
	public void addAmount(int amount) {
		productAmounts.add(amount);
	}
	public List<Integer> getProductAmounts() {
		return productAmounts;
	}
	public User getUser() {
		return user;
	}
	public Customer getCustomer() {
		return customer;
	}
}