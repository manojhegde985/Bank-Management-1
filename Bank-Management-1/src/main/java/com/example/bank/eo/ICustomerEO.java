package com.example.bank.eo;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagement1Application;
import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;

public interface ICustomerEO {
	
	static final Logger logger = LoggerFactory.getLogger(BankManagement1Application.class);
  public default String ServiceLog() {
	logger.info("this is a customer management entity file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "ServiceLog";
	}
public List<CustomerDto> getAllCustomers();
		
public CustomerDto getCustomer(Integer cid);

public CustomerDto addCustomer(CustomerDto customer);

public String healthCheck(Integer cid);


		

	}


