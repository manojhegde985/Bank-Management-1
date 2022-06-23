package com.example.bank.eo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.bank.BankManagement1Application;
import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;
import com.example.bank.exception.CustomerNotFoundException;
import com.example.bank.mapstruct.MapstructMapper;
import com.example.bank.repository.IBankRepository;





@Component
public class CustomerEO implements ICustomerEO{
@Autowired
private IBankRepository repository;
@Autowired
private MapstructMapper mapstruct;

private static final Logger logger = LoggerFactory.getLogger(BankManagement1Application.class);
public String ServiceLog() {
logger.info("this is a customer management entity file ");
logger.warn("this is a warn message");
logger.error("this is an error message");
return "ServiceLog";
}




public List<CustomerDto> getAllCustomers() {
List<CustomerDto> allCustomers=repository.findAll();
return allCustomers;
}

public CustomerDto getCustomer(Integer cid) {
return repository.findById(cid);

}

@Override
public CustomerDto addCustomer(CustomerDto customer) {
	return repository.save(customer);
}



@Override
public String healthCheck(Integer cid) {

CustomerDto s = repository.findById(cid);
if(s.getCid() != null) {
return ("HealthCheck-Success");
}
else {
return ("HealthCheck-Failure");
}
}


}
