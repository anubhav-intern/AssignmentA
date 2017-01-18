package model;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String state;
	private String country;
	private String mobile;
	private String email;
	private String tag;
	
	public Customer()
	{}
	
	public Customer(String name, String address,String state, String country, String mobile, String email)
	{
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.mobile = mobile;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
