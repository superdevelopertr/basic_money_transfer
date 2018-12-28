package com.ailhanli.money_transfer.repository;

import java.util.HashMap;
import java.util.Map;

import com.ailhanli.money_transfer.domain.Customer;

public class CustomerRepository {

	private Map<String, Customer> database = new HashMap<>();

	public Boolean save(Customer newCustomer) {
		try {
			database.put(newCustomer.getId(), newCustomer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}