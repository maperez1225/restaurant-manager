package model;
import java.util.ArrayList;
public class RestaurantManager{
	private ArrayList<User> users;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Product> products;
	private ArrayList<ProductType> types;
	private ArrayList<Customer> customers;
	private ArrayList<Order> orders;
	public RestaurantManager() {
		users = new ArrayList<User>();
		ingredients = new ArrayList<Ingredient>();
		products = new ArrayList<Product>();
		types = new ArrayList<ProductType>();
		customers = new ArrayList<Customer>();
		orders = new ArrayList<Order>();
	}
}