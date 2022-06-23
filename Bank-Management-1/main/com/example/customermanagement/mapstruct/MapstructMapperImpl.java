package com.example.customermanagement.mapstruct;

import com.example.customermanagement.dto.CustomerDto;
import com.example.customermanagement.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-17T21:57:49+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class MapstructMapperImpl implements MapstructMapper {

    @Override
    public CustomerDto customerToCustomerDto(Integer cid) {
        if ( cid == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCid( cid );

        return customerDto;
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCid( customer.getCid() );
        customerDto.setCname( customer.getCname() );
        customerDto.setCity( customer.getCity() );
        customerDto.setEmail( customer.getEmail() );

        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setCid( customer.getCid() );
        customer1.setCname( customer.getCname() );
        customer1.setCity( customer.getCity() );
        customer1.setEmail( customer.getEmail() );

        return customer1;
    }

    @Override
    public List<CustomerDto> customerToCustomerDtoList(List<Customer> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerDto> list1 = new ArrayList<CustomerDto>( list.size() );
        for ( Customer customer : list ) {
            list1.add( customerToCustomerDto( customer ) );
        }

        return list1;
    }

    @Override
    public List<Customer> customerDtoToCustomerList(List<CustomerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Customer> list1 = new ArrayList<Customer>( list.size() );
        for ( CustomerDto customerDto : list ) {
            list1.add( customerDtoToCustomer( customerDto ) );
        }

        return list1;
    }
}
