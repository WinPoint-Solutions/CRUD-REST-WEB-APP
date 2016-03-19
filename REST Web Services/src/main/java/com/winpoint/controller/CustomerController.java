package com.winpoint.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.winpoint.model.Customer;
import com.winpoint.services.CustomerServices;
import com.winpoint.services.CustomerServicesImpl;

@RestController
public class CustomerController {

	CustomerServices customerServices = new CustomerServicesImpl();
	
	@RequestMapping(value="/CustCRUDRestService/customer", method = RequestMethod.POST)
    public Map<String, Object>createCustomer(@RequestBody Customer customer){
    	       	Map<String, Object> response = new HashMap<String, Object>();
    	    	System.out.println("From Create Customer");
    	    	customerServices.saveCustomer(customer);
    	    	response.put("message", "Customer created successfully");
    	    	response.put("customer", customer);
    			return response;
    	    }
    	
    @RequestMapping(value="/CustCRUDRestService/customer/{customerId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   	public ResponseEntity<Customer>getCustomerDetails(@PathVariable("customerId") String customerId){
	   	System.out.println("From Read Customer"+ customerId);
    	Customer customer = customerServices.findById(customerId);
    	return new ResponseEntity<Customer>(customer, HttpStatus.OK );
    }
    
	@RequestMapping(method = RequestMethod.PUT, value="/CustCRUDRestService/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") String customerId, @RequestBody Customer customer){
    	System.out.println("From Update Customer");
    	//Customer newCustomer = new Customer("3","WinPoint");
    	customerServices.updateCustomer(customer);
    	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    
	@RequestMapping(method = RequestMethod.DELETE, value="/CustCRUDRestService/customer/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") String customerId){
    	System.out.println("From Delete Customer");
    	customerServices.deleteCustomerById(customerId);
    	//Map<String, Object> response = new HashMap<String, Object>();
    	//response.put("message", "Customer deleted successfully");
	//	return response;
	return new ResponseEntity<Customer>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/CustCRUDRestService/customer")
    public ResponseEntity<List<Customer>> getAllCustomers(){
    	System.out.println("From getAllCustomers");
    	List<Customer> customers = customerServices.findAllCustomers();
    	if(customers.isEmpty()) {
    		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/CustCRUDRestService/customer", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteAllCustomers() {
        System.out.println("Deleting All Users");
 
        customerServices.deleteAllCustomers();
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
 
}