package com.ailhanli.money_transfer.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;


import com.ailhanli.money_transfer.domain.Customer;
import com.ailhanli.money_transfer.repository.CustomerRepository;
import com.ailhanli.money_transfer.service.CustomerService;
import com.ailhanli.money_transfer.validator.CustomerValidator;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@Mock
	private CustomerRepository repository;
	
	@Mock
	private CustomerValidator validator;
	
	@InjectMocks
	private CustomerService service;
	
	@Test
	public void test_create_new_valid_customer() {
		
		Customer newCustomer = new Customer("12345678901","Name1", "Surname1");
		when(repository.save(any())).thenReturn(Boolean.TRUE);
		when(validator.isvalidInput(any())).thenReturn(Boolean.TRUE);
		
		Boolean result = service.save(newCustomer);
		
		assertTrue(result);
		verify(repository, times(1)).save(any());
		verify(validator, times(1)).isvalidInput(any());
	}
}