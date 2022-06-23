package com.example.bank.repository;

import java.util.List;

import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;



public interface IBankRepository {
	
public int count();

public List<CustomerDto> findAll();
public CustomerDto findById(int cid);
public CustomerDto save(CustomerDto customer);

//public void save(Bank cus);





}
