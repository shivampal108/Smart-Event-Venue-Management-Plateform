package com.customer.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customexception.CustomerNotFoundException;
import com.customer.dto.CustomerRequestDto;
import com.customer.dto.CustomerResponseDto;
import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImp implements CustomerService {
	
	
	@Autowired
	
	private CustomerRepository custRepo;
	
	

	@Override
	public CustomerResponseDto addCustomer(CustomerRequestDto customer) {
		// TODO Auto-generated method stub
		
		
		Customer c1=new Customer();
		
		BeanUtils.copyProperties(customer, c1);
		
	c1=	custRepo.save(c1);
	
	CustomerResponseDto response=new CustomerResponseDto();
	
	BeanUtils.copyProperties(c1, response);
	
	return  response;
				
	}

	@Override
	public CustomerResponseDto viewCustomer(Long id) {
		// TODO Auto-generated method stub
		
		
				
				
			Customer c1=custRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("customer not present"));
			
			CustomerResponseDto c2=new CustomerResponseDto();
			
			BeanUtils.copyProperties(c1,c2);
			
			
				return c2;
	}

	@Override
	public List<CustomerResponseDto> viewAllCustomer() {
		
		
		List<Customer> customers=custRepo.findAll();
		
		List<CustomerResponseDto> dtos=new ArrayList<CustomerResponseDto>();
		
		for(Customer c :customers) {
			
			CustomerResponseDto c1=new CustomerResponseDto();
			BeanUtils.copyProperties(c,c1);
			dtos.add(c1);
		}
		
		
		return dtos;
	}

	@Override
	public String deleteCustomer(Long id) {
		
		
		custRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("customer not present for deletion"));
		
		custRepo.deleteById(id);
		
		return "deleted having id : "+ id;
				
	}

	@Override
	public CustomerResponseDto updateCustomer(CustomerRequestDto customer, long id) {
		// TODO Auto-generated method stub
		
		Customer cust1= 	custRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("customer not present for updating"));
		
		BeanUtils.copyProperties(customer, cust1);
		cust1.setCustommerId(id);
		
		custRepo.save(cust1);
		
		CustomerResponseDto responseDto= new CustomerResponseDto();
		
		BeanUtils.copyProperties( cust1,responseDto);

		
		
		return  responseDto;
		
		
		
	}
	
	

}
