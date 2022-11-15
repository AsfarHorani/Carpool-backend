package com.carpool.service;

import com.carpool.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer getCustomer(long customerId);
	public void deleteCustomer(long customerId);
    
}
