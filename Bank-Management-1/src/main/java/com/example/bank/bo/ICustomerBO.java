package com.example.bank.bo;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagement1Application;
import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;

public interface ICustomerBO {
	
	static final Logger logger = LoggerFactory.getLogger(BankManagement1Application.class);
  public default String ServiceLog() {
	logger.info("this is a customer management bo file ");
     
	return "ServiceLog";
	}
public List<CustomerDto> getAllCustomers();
		
public CustomerDto getCustomer(Integer cid);

public CustomerDto addCustomer(CustomerDto customer);

public String healthCheck(Integer cid);


		

	}


