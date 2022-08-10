package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;

public class EmployeeServicesController {
	
	private EmployeeDAO employeeDao = new EmployeeDAOImpl();
	
	public void checkEmployeeLogin(Employee employee) {
		employeeDao.validateEmployeeLogin(employee);
	}
	
	public List<Customer> customerApplications(){
		return employeeDao.getApplications();
	}

	public void updateCustomerAppl(Customer customer) {
		employeeDao.updateCustomerApplication(customer);
	}

	public void createFinancialAccount(Customer customer) {
		employeeDao.createFinancialAcct(customer);
		
	}

	public List<Customer> displayCustomerAccounts(){
		return employeeDao.displayCustomerAccts();
	}
	
	
	
	
}//class