package model;
import java.io.Serializable;
public class Customer implements Serializable, Comparable<Customer>{
	private static final long serialVersionUID = 1;
	private String name;
	private String lastName;
	private long id;
	private String address;
	private long phone;
	private String observations;
	public Customer(String name, String lastName, long id, String address, long phone, String observations) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.observations = observations;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	@Override
	public int compareTo(Customer o) {
		return this.lastName.compareTo(o.getLastName());
	}
}