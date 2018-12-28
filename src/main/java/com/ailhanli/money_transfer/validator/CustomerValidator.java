package com.ailhanli.money_transfer.validator;

import com.ailhanli.money_transfer.domain.Customer;

public class CustomerValidator {

	public boolean isvalidInput(Customer newCustomer) {
		if(newCustomer==null) {
			return false;
		}else {
			String id = newCustomer.getId();
			if(id==null || id.trim().equals("")) {
				return false;
			}
			
			if(id.length()!=11) {
				return false;
			}
			
			Character invalidChracter= id.chars().mapToObj(c->(char)c).filter(c->!Character.isDigit(c)).findFirst().orElse(null);
			if(invalidChracter!=null) {
				return false;
			}
			
			return true;
		}
	}

}