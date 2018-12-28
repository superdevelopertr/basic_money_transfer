package com.ailhanli.money_transfer.service;

import com.ailhanli.money_transfer.domain.Customer;
import com.ailhanli.money_transfer.repository.CustomerRepository;
import com.ailhanli.money_transfer.validator.CustomerValidator;

public class CustomerService {

	private CustomerRepository repository;
	
	private CustomerValidator validator;

	public CustomerService(CustomerRepository repository, CustomerValidator validator) {
		super();
		this.repository = repository;
		this.validator = validator;
	}

	public Boolean save(Customer newCustomer) {

		if (!validator.isvalidInput(newCustomer)) {
			throw new IllegalArgumentException();
		}
		
		Boolean result = repository.save(newCustomer);
		return result;
	}
}