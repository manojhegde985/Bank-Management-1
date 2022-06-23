package com.example.bank.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;



@Mapper(componentModel="spring")
public interface MapstructMapper {
CustomerDto customerToCustomerDto(Integer cid);

CustomerDto customerToCustomerDto(Customer customer);

Customer customerDtoToCustomer(CustomerDto customer);

List<CustomerDto> customerToCustomerDtoList(List<Customer> list);

List<Customer> customerDtoToCustomerList(List<CustomerDto> list);
}