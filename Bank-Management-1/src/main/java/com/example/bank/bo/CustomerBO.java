 package com.example.bank.bo;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.bank.BankManagement1Application;
import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;
import com.example.bank.eo.CustomerEO;
import com.example.bank.exception.CustomerNotFoundException;
import com.example.bank.mapstruct.MapstructMapper;
import com.example.bank.repository.IBankRepository;





@Component
public class CustomerBO implements ICustomerBO{
@Autowired
private CustomerEO eo;
@Autowired
private MapstructMapper mapstruct;


private static final Logger logger = LoggerFactory.getLogger(CustomerBO.class);
public String ServiceLog() {
logger.info("this is a customer management bo file ");
return "ServiceLog";
}


public List<CustomerDto> getAllCustomers() {
	List<CustomerDto> allCustomers=eo.getAllCustomers();
	return allCustomers;
}

public CustomerDto getCustomer(Integer cid) {
return eo.getCustomer( cid);

}

@Override
public CustomerDto addCustomer(CustomerDto customer) {
	return eo.addCustomer(customer);
}



public String healthCheck(Integer cid) {
	return eo.healthCheck(cid);
}






}
