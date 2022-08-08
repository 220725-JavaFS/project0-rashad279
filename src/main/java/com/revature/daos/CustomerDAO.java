package com.revature.daos;

import com.revature.models.Customer;

public interface CustomerDAO {
	
	public abstract void insertCustomer(Customer customer);
	
	public abstract void validateCustomerLogin(Customer customer);
	
	public abstract void importCustomerApplication(Customer customer);

}