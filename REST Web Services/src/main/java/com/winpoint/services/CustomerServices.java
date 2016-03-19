package com.winpoint.services;

import java.util.List;

import com.winpoint.model.Customer;

public interface CustomerServices {

	 	Customer findById(String id);
     
	    Customer findByName(String name);
	     
	    void saveCustomer(Customer customer);
	     
	    void updateCustomer(Customer customer);
	     
	    void deleteCustomerById(String id);
	 
	    List<Customer> findAllCustomers(); 
	     
	    void deleteAllCustomers();
	     
	    public boolean isCustomerExist(Customer customer);
	     
}
