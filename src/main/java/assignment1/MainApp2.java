package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daoImplementation.CustomerJDBCTemplate;
import model.Customer;

@RestController
public class MainApp2 {
	
	static ApplicationContext context = 
            new ClassPathXmlApplicationContext("Beans.xml");

     static CustomerJDBCTemplate customerJDBCTemplate = 
     (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");
	      
     @PostMapping("/customers")
	public static String insert(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="address", defaultValue="") String address,@RequestParam(value="state", defaultValue="") String state,@RequestParam(value="country", defaultValue="") String country,@RequestParam(value="mobile", defaultValue="") String mobile,@RequestParam(value="email", defaultValue="") String email)
	{
		
	     customerJDBCTemplate.create(name,address,state,country,mobile,email);
	     return "Record created successfully!!";
	}
	
     @PutMapping("/customers")
	public static String updateNumberGivenEmail(@RequestParam(value="email", defaultValue="") String email, @RequestParam(value="mobile", defaultValue="") String mobile)
	{
		
		int x = customerJDBCTemplate.update(email, mobile);
		if(x == 0)
			return "No such record found!!";
		 return "Record updated successfully!!";
		
	}
     
     @PostMapping("/taggedCustomer")
	public static String taggedCustomerCreation(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="address", defaultValue="") String address,@RequestParam(value="state", defaultValue="") String state,@RequestParam(value="country", defaultValue="") String country,@RequestParam(value="mobile", defaultValue="") String mobile,@RequestParam(value="email", defaultValue="") String email,@RequestParam(value="tag", defaultValue="") String tag)
	{
		
	     customerJDBCTemplate.createCustomerWithATag(name,address,state,country,mobile,email,tag);
	     return "Customer with tag created suucessfully";
	}
	
	@GetMapping("/customers")
	public static List<Customer> print()
	{
		 
	      List<Customer> customers = customerJDBCTemplate.listCustomers();
	      return customers;
	      
	}
	
	@PostMapping("/customers/tag")
    public static String tagIt(@RequestParam(value="email", defaultValue="") String email, @RequestParam(value="name", defaultValue="") String name)
    {		
		
	    return	customerJDBCTemplate.createTag(email, name);
		
    }
	
    @RequestMapping("/customers/country/{name}")
    public static List<Customer> customersInASpecifiedCountry(@PathVariable("name") String name)
    {
   
	      List<Customer> customers = customerJDBCTemplate.getCustomers(name);
	      return customers;
    }
    
    @RequestMapping("/customers/tag/{name}")
    public static List<Customer> customersWithASpecifiedTag(@PathVariable("name") String name)
    {
    	
	      List<Customer> customers = customerJDBCTemplate.listCustomersWithTag(name);
	      return customers;
    }
    
    @PutMapping("/customers/tag")
    public static String updateCustomerTag(@RequestParam(value="email", defaultValue="") String email, @RequestParam(value="oldTag", defaultValue="") String oldTag, @RequestParam(value="newTag", defaultValue="") String newTag)
    {
    	
    	customerJDBCTemplate.updateTag(email, oldTag, newTag);
    	return "Record updated successfully!!";
    	
    }
    
    @RequestMapping("/customers/country")
    public static List<Customer> customersInCountries(@RequestParam(value="name", defaultValue="") String name)
    {	
  
    	ArrayList<String> list = new ArrayList<>();
    	list = new ArrayList<String>(Arrays.asList(name.split("\\s*,\\s*")));
		
		List<Customer> customers = customerJDBCTemplate.customersInCountries(list);
		return customers;
    }

    @RequestMapping("/customers/tag")
    public static List<Customer> customerWithTags(@RequestParam(value="name", defaultValue="") String name)
    {
    	
    	ArrayList<String> list = new ArrayList<>();
    	list = new ArrayList<String>(Arrays.asList(name.split("\\s*,\\s*")));	
		List<Customer> customers = customerJDBCTemplate.customersWithTags(list);
		
		return customers;
    }
}

