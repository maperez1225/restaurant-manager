package model;
import java.io.Serializable;
import java.util.List;
public class Product implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private ProductType type;
	private List<Ingredient> ingredients;
	private String size;
	private int price;
	private boolean enabled;
	public Product(String name, ProductType type, List<Ingredient> ingredients, String size, int price) {
		this.name = name;
		this.type = type;
		this.ingredients = ingredients;
		this.size = size;
		this.price = price;
		setEnabled(true);
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name+" - "+size;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}