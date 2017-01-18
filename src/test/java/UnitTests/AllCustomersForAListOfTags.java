package UnitTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import daoImplementation.CustomerJDBCTemplate;
import junit.framework.Assert;
import model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:Beans.xml")
public class AllCustomersForAListOfTags {
	
	@Autowired
	private CustomerJDBCTemplate customerJDBCTemplate = new CustomerJDBCTemplate();
	@Test
	public void contextLoads() {
		
		String name = "";
		ArrayList<String> list = new ArrayList<>();
    	list = new ArrayList<String>(Arrays.asList(name.split("\\s*,\\s*")));
		
		
		Assert.assertEquals(null, customerJDBCTemplate.customersWithTags(list));
		
		
	}

}
