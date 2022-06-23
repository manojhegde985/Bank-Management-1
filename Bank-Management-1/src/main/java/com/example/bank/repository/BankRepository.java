package com.example.bank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;
@Repository
public class BankRepository implements IBankRepository {

	  private JdbcTemplate jdbcTemplate;
	  
	  public BankRepository(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	  
	@Override
	public int count() {
		
		return 0;
	}

	@Override
	public CustomerDto save(CustomerDto customer) {
		
		String sql = "INSERT INTO customer (cid,cname,city,email)"
                + " VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(sql, customer.getCid(), customer.getCname(),customer.getCity(),
            customer.getEmail());
	return customer;
	}

	@Override
	public List<CustomerDto> findAll() {
		String sql = "SELECT * FROM customer";
	    List<CustomerDto> listCustomer = jdbcTemplate.query(sql, new RowMapper<CustomerDto>() {
		
	    	 public CustomerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	             CustomerDto customer = new CustomerDto();
	  
	             customer.setCid(rs.getInt("cid"));
	             customer.setCname(rs.getString("cname"));
	             customer.setCity(rs.getString("city"));
	             customer.setEmail(rs.getString("email"));
	            
	             return customer;
	         }
	  
	     });
	  
	     return listCustomer;
	}

	@Override
	public CustomerDto findById(int cid) {
		 String sql = "SELECT * FROM customer WHERE customer_id=" + cid;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<CustomerDto>() {
		    	 public CustomerDto extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                CustomerDto contact = new CustomerDto();
	                contact.setCid(rs.getInt("cid"));
	                contact.setCname(rs.getString("fname"));
	                contact.setCity(rs.getString("lname"));
	                contact.setEmail(rs.getString("address"));
	                return contact;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	
}
