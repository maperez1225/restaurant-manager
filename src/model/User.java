package model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String lastName;
	private long id;
	public User(String name, String lastName, long id) {
		this.setName(name);
		this.setLastName(lastName);
		this.setId(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}