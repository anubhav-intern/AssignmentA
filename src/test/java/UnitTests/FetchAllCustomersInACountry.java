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
public class FetchAllCustomersInACountry {
	
	@Autowired
	private CustomerJDBCTemplate customerJDBCTemplate = new CustomerJDBCTemplate();
	@Test
	public void contextLoads() {
		
		Assert.assertEquals(null, customerJDBCTemplate.getCustomers(""));
		Assert.assertEquals(2, customerJDBCTemplate.getCustomers("USA").size());
		
		
	}

}
