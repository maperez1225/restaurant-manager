package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Restaurant{
	private List<User> users;
	private List<Ingredient> ingredients;
	private List<Product> products;
	private List<ProductType> types;
	private List<Customer> customers;
	private List<Order> orders;
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
	@SuppressWarnings("unchecked")
	public boolean loadData() throws IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE);
		boolean loaded = false;
		if (f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			users = (List<User>)ois.readObject();
			ingredients = (List<Ingredient>)ois.readObject();
			products = (List<Product>)ois.readObject();
			types = (List<ProductType>)ois.readObject();
			customers = (List<Customer>)ois.readObject();
			orders = (List<Order>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	public void addUser(User user) throws IOException {
		users.add(user);
		saveData();
	}
	public User getUser(int index) {
		User user = users.get(index);
		return user;
	}
	public int getUser(String username) {
		boolean found = false;
		int index = -1;
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
	public int getIngredient(String name) {
		int index = -1;
		boolean found = false;
		if (!ingredients.isEmpty()) {
			for (int i = 0; i < ingredients.size() && !found; i++)
				if (ingredients.get(i).getName().equalsIgnoreCase(name)) {
					found = true;
					index = i;
				}
		}
		return index;
	}
	public int getProduct(String name) {
		int index = -1;
		boolean found = false;
		if (!products.isEmpty()) {
			for (int i = 0; i < products.size() && !found; i++)
				if (products.get(i).getName().equalsIgnoreCase(name)) {
					found = true;
					index = i;
				}
		}
		return index;
	}
	public void addIngredient(Ingredient ingredient) throws IOException {
		ingredients.add(ingredient);
		saveData();
	}
	public void addProduct(Product product) throws IOException {
		products.add(product);
		saveData();
	}
	public void addType(ProductType type) throws IOException {
		types.add(type);
		saveData();
	}
	public void addCustomer(Customer customer) throws IOException {
		if (customers.isEmpty()) {
			customers.add(customer);
			saveData();
		}
		else {
			int i = 0;
			while (i<customers.size() && customer.compareTo(customers.get(i)) > 0) {
				i++;
			}
			customers.add(i, customer);
			saveData();
		}
	}
	public void addOrder(Order order) throws IOException {
		orders.add(order);
		saveData();
	}
	/*
	 * Para satisfacer el requerimiento de implementar una búsqueda del cliente en el área de pedidos, hemos decidido realizar la búsqueda con el teléfono, ya que
	 * es más representativo de la utilidad en un restaurante, ya que normalmente al realizar el pedido, le piden al cliente su teléfono y con ese dato se puede
	 * referenciar al cliente, mientras que con nombres es menos útil para un restaurante.
	 */
	public int getCustomer(long phone) {
		boolean found = false;
		int index = -1;
		for (int i = 0; i < customers.size() && !found; i++) {
			if (customers.get(i).getPhone() == phone) {
				index = i;
				found = true;
			}
		}
		return index;
	}
	public Customer getCustomer(int index) {
		return customers.get(index);
	}
	public void deleteCustomer(int index) {
		customers.remove(index);
	}
	public List<Customer> getCustomers(){
		return customers;
	}
	public List<ProductType> getTypes(){
		return types;
	}
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	public List<Product> getProducts() {
		return products;
	}
	public List<Order> getActiveOrders(){
		List<Order> activeOrders = new ArrayList<Order>();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getStatus() != Order.Status.DELIVERED)
				activeOrders.add(orders.get(i));
		}
		return activeOrders;
	}
	public List<Order> getDeliveredOrders(){
		List<Order> deliveredOrders = new ArrayList<Order>();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getStatus() == Order.Status.DELIVERED)
				deliveredOrders.add(orders.get(i));
		}
		return deliveredOrders;
	}
}