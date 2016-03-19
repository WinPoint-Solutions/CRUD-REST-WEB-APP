package com.winpoint.client;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.winpoint.model.Customer;

public class CustomerRESTTemplateClient {
	public static final String REST_SERVICE_URI = "http://localhost:8080/CustCRUDRestService";
    
    /* GET All */
    @SuppressWarnings("unchecked")
    private static void listAllCustomers(){
        System.out.println("Testing - List All Customers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        
        List<LinkedHashMap<String, Object>> customersMap = restTemplate.getForObject(REST_SERVICE_URI+"/customer/", List.class);
        
        if(customersMap!=null){
            for(LinkedHashMap<String, Object> map : customersMap){
                System.out.println("Customer : id="+map.get("customer_id")+", Name="+map.get("customer_name"));
            }
        }else{
            System.out.println("No Customers exist----------");
        }
        System.out.println("*******************************************");
    }
     
    /* GET */
    private static void readCustomer(){
    	
        System.out.println("Testing - Read Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(REST_SERVICE_URI+"/customer/1", Customer.class);
        System.out.println("Customer details are :" + customer);
        System.out.println("*******************************************");
    }
     
    /* POST */
    private static void createCustomer() {
        System.out.println("Testing - Create Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = new Customer("5","Webonise");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/customer/", customer, com.winpoint.model.Customer.class);
        System.out.println("Customer created successfully");
        System.out.println("*******************************************");
    }
 
    /* PUT */
    private static void updateCustomer() {
        System.out.println("Testing Update Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        com.winpoint.model.Customer customer  = new com.winpoint.model.Customer("3","Parkhi");
        restTemplate.put(REST_SERVICE_URI+"/customer/3", customer, Customer.class);
        System.out.println("Customer updated successfully : " + customer);
        System.out.println("*******************************************");
    }
 
    /* DELETE */
    private static void deleteCustomer() {
        System.out.println("Testing - Delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/customer/3");
        System.out.println("Customer deleted successfully");
        System.out.println("*******************************************");
    }
 
 
    /* DELETE All*/
    private static void deleteAllCustomers() {
        System.out.println("Testing - Delete All Customers API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/customer/");
        System.out.println("*******************************************");
    }
	/**
	 * @param args
	 */
/*
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		createCustomer();
	    readCustomer();
		updateCustomer();
		listAllCustomers();
		deleteCustomer();
		
		listAllCustomers();
		
		deleteAllCustomers();
		listAllCustomers();
	}
*/	

}
