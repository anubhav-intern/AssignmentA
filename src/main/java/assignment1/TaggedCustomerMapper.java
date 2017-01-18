package assignment1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Customer;

public class TaggedCustomerMapper implements RowMapper<Customer> {
	   public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Customer customer = new Customer();
		      customer.setId(rs.getInt("id"));
		      customer.setName(rs.getString("name"));
		      customer.setAddress(rs.getString("address"));
		      customer.setState(rs.getString("state"));
		      customer.setCountry(rs.getString("country"));
		      customer.setMobile(rs.getString("mobile"));
		      customer.setEmail(rs.getString("email"));
		      customer.setTag(rs.getString("tagName"));
		      return customer;
		   }

}
