package dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Customer;

public interface CustomerDAO {

	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   
	   /** 
	    * This is the method to be used to create
	    * a record in the Customer table.
	    */
	   public void create(String name, String address,String state, String country, String mobile, String email);
	   
	   /** 
	    * This is the method to be used to list down
	    * a record from the Customer table corresponding
	    * to a passed customer email.
	    */
	   public Customer getCustomer(String email);
	   
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Customer table corresponding
	    * to a passed customer country.
	    */
	   public List<Customer> getCustomers(String country);
	  
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Customer table.
	    */
	   public List<Customer> listCustomers();
	   
	   /**
	    * This is the method used to list down
	    * all the customers with a specified tag.
	    */
	   public List<Customer> listCustomersWithTag(String tag);
	  
	   
	   /** 
	    * This is the method to be used to update
	    * a record into the Customer table.
	    */
	   public int update(String email, String mobile);
	   
	   /**
	    * This method is used to add a 
	    * new tag into the record for a customer
	    */
	   public String createTag(String email,String name);
	   
	   /**
	    * This method is used to create
	    * a customer with a tag
	    */
	   public void createCustomerWithATag(String name, String address,String state, String country, String mobile, String email,String tag);
	   
	   /**
	    * This method is used to update
	    * a tag for the customer
	    */
	   public void updateTag(String email,String oldTag,String newTag);
	   
	   /**
	    * This method is used to fetch customers
	    * within a specified list of countries
	    */
	   public List<Customer> customersInCountries(ArrayList<String> countries);
	   
	   /**
	    * This method is used to fetch customers
	    * within a specified list of tags
	    */
	   public List<Customer> customersWithTags(ArrayList<String> tags);

}
