package model;
import java.io.Serializable;
public class User implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private String lastName;
	private long id;
	private String username;
	private String password;
	public User(String username, String password, String name, String lastName, long id){
		this.setUsername(username);
		this.setPassword(password);
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}