package model;
import java.util.ArrayList;
public class Restaurant{
	private ArrayList<User> users;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Product> products;
	private ArrayList<ProductType> types;
	private ArrayList<Customer> customers;
	private ArrayList<Order> orders;
	public Restaurant() {
		users = new ArrayList<User>();
		ingredients = new ArrayList<Ingredient>();
		products = new ArrayList<Product>();
		types = new ArrayList<ProductType>();
		customers = new ArrayList<Customer>();
		orders = new ArrayList<Order>();
	}
	public void addUser(User user) {
		users.add(user);
	}
	public int getUser(String username) {
		boolean found = false;
		int index = users.size();
		for (int i = 0; i < users.size() && !found; i++) {
			if (users.get(i).getUsername().equals(username)) {
				found = true;
				index = i;
			}
		}
		return index;
	}
	public boolean authenticateUser(int index, String password) {
		boolean correct = false;
		if (users.get(index).getPassword().equals(password))
			correct = true;
		return correct;
	}
	public boolean userExists(String username) {
		boolean exists = false;
		for (int i = 0; i < users.size() && !exists; i++)
			if (users.get(i).getUsername().equals(username))
				exists = true;
		return exists;
	}
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	public void addProduct(Product product) {
		products.add(product);
	}
	public void addType(ProductType type) {
		types.add(type);
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
}