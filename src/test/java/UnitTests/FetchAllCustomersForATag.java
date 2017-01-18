package UnitTests;

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
public class FetchAllCustomersForATag {
	
	@Autowired
	private CustomerJDBCTemplate customerJDBCTemplate = new CustomerJDBCTemplate();
	@Test
	public void contextLoads() {
		
		Assert.assertEquals(null, customerJDBCTemplate.listCustomersWithTag(""));
		Assert.assertEquals(3, customerJDBCTemplate.listCustomersWithTag("actor").size());
		
		
		
	}

}
