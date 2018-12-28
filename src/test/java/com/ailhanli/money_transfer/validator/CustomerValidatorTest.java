package com.ailhanli.money_transfer.validator;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ailhanli.money_transfer.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerValidatorTest {

	@InjectMocks
	private CustomerValidator validator;
	
	@Test
	public void test_customer_input_is_null() {	
		Boolean result = validator.isvalidInput(null);
		assertFalse(result);
	}
	
	
	@Test
	public void test_customer_input_id_is_null_or_empty() {
		Boolean result = validator.isvalidInput(new Customer(null, "", ""));
		assertFalse(result);
	}
	
	@Test
	public void test_customer_input_id_has_invalid_length() {
		Boolean result = validator.isvalidInput(new Customer("12", "", ""));
		assertFalse(result);
	}
	
	@Test
	public void test_customer_input_id_length_is_ok_but_has_invalid_character() {
		Boolean result = validator.isvalidInput(new Customer("12a", "", ""));
		assertFalse(result);
		
		result = validator.isvalidInput(new Customer("1111111111e", "", ""));
		assertFalse(result);
	}
}