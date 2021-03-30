package model;
import java.io.Serializable;
public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private boolean active;
	public Ingredient(String n, boolean a){
		name = n;
		active = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive() {
		active = true;
	}
	public void disable() {
		
	}
}