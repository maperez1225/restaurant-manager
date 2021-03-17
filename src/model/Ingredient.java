package model;
public class Ingredient {
	private String name;
	private boolean active;
	public Ingredient(String n){
		setName(n);
		setActive(true);
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
	public void setActive(boolean active) {
		this.active = active;
	}
}