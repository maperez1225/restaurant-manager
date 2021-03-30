package model;
import java.io.Serializable;
public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private boolean active;
	private User createdBy;
	private User lastEditedBy;
	public Ingredient(String n, boolean a, User c){
		name = n;
		active = a;
		createdBy = c;
		lastEditedBy = c;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
	public String getCreatedBy() {
		return createdBy.getUsername();
	}
	public String getLastEditedBy() {
		return lastEditedBy.getUsername();
	}
	public void setLastEditedBy(User e) {
		lastEditedBy = e;
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