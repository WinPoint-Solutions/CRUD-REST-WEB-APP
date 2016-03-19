package com.winpoint.model;

public class Customer {
	String customer_id;
	String customer_name;
		
	public Customer(){
		
	}
	public Customer(String customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name="
				+ customer_name + "]";
	}
	
}

