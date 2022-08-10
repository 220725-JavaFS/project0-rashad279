package com.revature.daos;

import java.util.List;

import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;

public interface AdminDAO {
	
	public abstract void validateAdminLogin(Admin admin); 

	public abstract void importNewEmployee(Employee employee);
	
	public List <Employee> adminViewEmployeeAccts(Employee employee);
	
	public abstract void changeCustomAddr(Customer customer);

	public abstract void changeEmployeeLogin(Employee employee);

	public abstract void deleteEmployee(Employee employee);

	public abstract void alterCustomerLogin(Customer customer);

	public abstract void changeCustomerAcctBal(Finance finance);

	public abstract void removeCustomerAcct(Finance finance);
	
	
}