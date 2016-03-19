package com.winpoint.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.model.Customer;

public class CustomerServicesImpl implements CustomerServices {
	
	private static List<Customer> customers;
    
    static{
        customers = populateDummyCustomers();
    }

	public Customer findById(String customerId) {
		for(Customer customer : customers){
            if(customer.getCustomer_id().equals(customerId)){
                return customer;
            }
        }
        System.out.println("From findById : " + customerId);
		return null;
	}

	public Customer findByName(String name) {
		System.out.println("From findByName : " + name);
		return null;
	}

	public void saveCustomer(Customer customer) {
		customers.add(customer);
		System.out.println("From Create Customer : " + customer.getCustomer_id() + customer.getCustomer_name());
		
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int index;
		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer existingCustomer = iterator.next();
            if (existingCustomer.getCustomer_id().equals(customer.getCustomer_id())) {
            	index = customers.indexOf(existingCustomer);
            	System.out.println("Index is " + index);
            	customers.set(index, customer);
            }
        }
		System.out.println("From updateCustomer : " + customer.getCustomer_id() + customer.getCustomer_name());
	}

	public void deleteCustomerById(String customerId) {
		
		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer customer = iterator.next();
            if (customer.getCustomer_id().equals(customerId)) {
                iterator.remove();
            }
        }
	}

	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		System.out.println("From findAllCustomers");
		return customers;
	}

	public void deleteAllCustomers() {
		// TODO Auto-generated method stub
		System.out.println("From deleteAllCustomers");
		customers.clear();
	}

	public boolean isCustomerExist(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("From Does customer exist : "+ customer.getCustomer_id() + customer.getCustomer_name());
		return false;
	}

	static List<Customer> populateDummyCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("1", "ABC"));
        customers.add(new Customer("2", "LMN"));
        customers.add(new Customer("3", "PQR"));
        customers.add(new Customer("4", "XYZ"));
        return customers;	
	}
}
