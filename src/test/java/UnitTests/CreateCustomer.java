package UnitTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import daoImplementation.CustomerJDBCTemplate;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:Beans.xml")
public class CreateCustomer {
		
	@Autowired
	private CustomerJDBCTemplate customerJDBCTemplate = new CustomerJDBCTemplate();
	@Test (expected=Exception.class)
	public void contextLoads() {
		
		customerJDBCTemplate.create("Junit", "abc", "KA", "India", "9897048618", "anu@gmail.com");
		
			
		}

}
