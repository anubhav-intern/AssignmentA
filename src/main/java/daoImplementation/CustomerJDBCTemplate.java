package daoImplementation;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import assignment1.CustomerMapper;
import assignment1.TaggedCustomerMapper;
import dao.CustomerDAO;
import model.Customer;

public class CustomerJDBCTemplate implements CustomerDAO {
		   private DataSource dataSource;
		   private JdbcTemplate jdbcTemplateObject;
		   
		   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }

		   public void create(String name, String address, String state, String country, String mobile, String email) {
		      String SQL = "insert into demo4 (name, address, state, country, mobile, email) values (?, ?, ?, ?, ?, ?)";
		      
		      jdbcTemplateObject.update( SQL, name, address, state, country, mobile, email);
		      System.out.println("Created Record Name = " + name + " Address = " + address +" State = "+state+" Country = "+country+" Mobile = "+mobile+" Email = "+email);
		      return;
		   }

		   public Customer getCustomer(String email) {
		      String SQL = "select * from demo4 where email = ?";
		      
		      List<Customer> customer = null;
		      customer = jdbcTemplateObject.query(SQL, 
		                        new Object[]{email}, new CustomerMapper());
		      if(customer.size() == 0)
		    	  return null;
		      return customer.get(0);
		   }
		   
		   public List<Customer> getCustomers(String country)
		   {
			   String SQL = "select * from demo4 where country = ?";
			      List <Customer> customers = jdbcTemplateObject.query(SQL, new Object[]{country}, 
			                                new CustomerMapper());
			      if(customers.size() == 0)
			    	  return null;
			      return customers;
		   }

		   public List<Customer> listCustomers() {
		      String SQL = "select * from demo4";
		      List <Customer> customers = jdbcTemplateObject.query(SQL, 
		                                new CustomerMapper());
		      return customers;
		   }
		   
		   public List<Customer> listCustomersWithTag(String name)
		   {	
			   
			   String SQL = "SELECT id, name, address, state, country, mobile,email,tagName FROM demo4,tag4 WHERE demo4.id = tag4.id AND tagName = ?";
			   List <Customer> customers = jdbcTemplateObject.query(SQL, new Object[]{name},
                       new TaggedCustomerMapper());
			   if(customers.size() == 0)
				   return null;
			   	return customers;
		   }

		   public int update(String email, String mobile){
		      String SQL = "update demo4 set mobile = ? where email = ?";
		      int x = 0;
		      x = jdbcTemplateObject.update(SQL, mobile, email);
		      return x;
		   }
		   
		   public String createTag(String email,String name)
		   {	
			   String SQL;
			   Customer customer = null;
			    customer = getCustomer(email);
			    if(customer == null)
			    	return "No such record found";
			    else
			    {
				   SQL = "insert into tag4 (id,tagName) values (?, ?)";
				       jdbcTemplateObject.update( SQL, customer.getId(),name);
				      return "Record updated successfully";
			    }
		   }
		   @Transactional(rollbackFor = Exception.class)
		   public void createCustomerWithATag(String name, String address,String state, String country, String mobile, String email,String tag)
		   {
			   
			   String SQL = "insert into demo4 (name, address, state, country, mobile, email) values (?, ?, ?, ?, ?, ?)";
			      
			      jdbcTemplateObject.update( SQL, name, address, state, country, mobile, email);
			         
			         createTag(email, tag);
			         
			         System.out.println("Created Record Name = " + name + " Address = " + address +" State = "+state+" Country = "+country+" Mobile = "+mobile+" Email = "+email+" Tag = "+tag);
			         
			         //throw new RuntimeException("simulate Error condition") ;
		   }
		   
		   public void updateTag(String email,String oldTag,String newTag)
		   {	
			   String SQL = "update tag4 set tagName = ? where id = ? and tagName = ?";
			   int cid = -1;
			   
			   cid = getCustomer(email).getId();
			   
			   if(cid == -1)
				   System.out.println("No such record found");
			   else
			   {
				   jdbcTemplateObject.update(SQL,newTag,cid,oldTag);
				   System.out.println("Record updated succesfully");
			   }
			
		   }
		   
		   public List<Customer> customersInCountries(ArrayList<String> countries)
		   {
			 //parsing the list
				String extract="";
				int i;
				for(i=0;i<countries.size()-1;i++)
				{	
					extract += "'";
					extract += countries.get(i);
					extract += "',";
				}
				extract += "'";
				extract += countries.get(i);
				extract += "'";
				
			   String SQL = "select * from demo4 where country in("+extract+")";
			      List<Customer> customers = jdbcTemplateObject.query(SQL, 
			                                new CustomerMapper());
			      if(customers.size() == 0)
			    	  return null;
			      return customers;
		   }
		   
		   public List<Customer> customersWithTags(ArrayList<String> tags)
		   {
			 //parsing the list
				String extract="";
				int i;
				for(i=0;i<tags.size()-1;i++)
				{	
					extract += "'";
					extract += tags.get(i);
					extract += "',";
				}
				extract += "'";
				extract += tags.get(i);
				extract += "'";
				
			   String SQL = "SELECT id, name, address, state, country, mobile,email,tagName FROM demo4,tag4 WHERE demo4.id = tag4.id AND tagName IN ("+extract+")";
			      List<Customer> customers = jdbcTemplateObject.query(SQL, 
			                                new TaggedCustomerMapper());
			      if(customers.size() == 0)
			    	  return null;
			      return customers;
			   
		   }

}
