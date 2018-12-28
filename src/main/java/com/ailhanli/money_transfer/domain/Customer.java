package com.ailhanli.money_transfer.domain;

public class Customer {

	private String id;
	private String name;
	private String surname;

	public Customer(String id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
}