package model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
public class Restaurant{
	private ArrayList<User> users;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Product> products;
	private ArrayList<ProductType> types;
	private ArrayList<Customer> customers;
	private ArrayList<Order> orders;
	public final static String SAVE_PATH_FILE = "data/appdata.ap2";
	public Restaurant() {
		users = new ArrayList<User>();
		ingredients = new ArrayList<Ingredient>();
		products = new ArrayList<Product>();
		types = new ArrayList<ProductType>();
		customers = new ArrayList<Customer>();
		orders = new ArrayList<Order>();
	}
	public void saveData() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
		oos.writeObject(users);
		oos.writeObject(ingredients);
		oos.writeObject(products);
		oos.writeObject(types);
		oos.writeObject(customers);
		oos.writeObject(orders);
		oos.close();
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
	public boolean customerExists(Customer customer) {
		boolean exists = false;
		if(!customers.isEmpty()){
			int index = Collections.binarySearch(customers, customer);
			if (index >= 0) {
				exists = true;
			}
		}
		return exists;
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
		if (customers.isEmpty())
			customers.add(customer);
		else {
			int i = 0;
			while (i<customers.size() && customer.compareTo(customers.get(i)) > 0) {
				i++;
			}
			customers.add(i, customer);
		}
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public ArrayList<Customer> getCustomers(){
		return customers;
	} 
}