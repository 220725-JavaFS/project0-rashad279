package com.revature.services;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customer;

public class CustomerServicesController {

	private CustomerDAO customerDao = new CustomerDAOImpl();
	
	public void createCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
	}
	
	public void checkCustomerLogin(Customer customer) {
		customerDao.validateCustomerLogin(customer);
	}
		
	public void addCustomerApplication(Customer customer) {
		customerDao.importCustomerApplication(customer);
	}
	
}