package com.revature.daos;

import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Finance;
import com.revature.models.Customer;


public interface EmployeeDAO {
	
	List <Customer> getApplications();

	public abstract void validateEmployeeLogin(Employee employee);
	
	public abstract void updateCustomerApplication(Customer customer);

	public abstract void createFinancialAcct(Customer customer);
	
	
}
