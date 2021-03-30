package model;
import java.io.Serializable;
public class ProductType implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private boolean active;
	public ProductType(String n) {
		name = n;
		active = true;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}