package com.revature.services;

import java.util.List;

import com.revature.daos.AdminDAO;
import com.revature.daos.AdminDAOImpl;
import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;

public class AdminServicesController {

	private AdminDAO adminDao = new AdminDAOImpl();
	
	public void checkAdminLogin(Admin admin) {
		adminDao.validateAdminLogin(admin);
	}
	
	public void createNewEmployee(Employee employee) {
		adminDao.importNewEmployee(employee);
	}
	
	
	public List <Employee> employeeAccountsView(Employee employee) {
		return adminDao.adminViewEmployeeAccts(employee);
	}

	public void updateEmployee(Employee employee) {
		adminDao.changeEmployeeLogin(employee);
		
	}

	public void removeEmployee(Employee employee) {
		adminDao.deleteEmployee(employee);
		
	}

	public void changeCustomerLogin(Customer customer) {
		adminDao.alterCustomerLogin(customer);
		
	}

	public void changeCustomerAddress(Customer customer) {
		adminDao.changeCustomAddr(customer);
		
	}

	public void changeCustomerAccountBal(Finance finance) {
		adminDao.changeCustomerAcctBal(finance);
		
	}

	public void removeCustomerAccount(Finance finance) {
		adminDao.removeCustomerAcct(finance);
		
	}

	public void changeCustomerAccountStatus(Customer customer) {
		adminDao.changeCustomerAcctStatus(customer);
		
	}

}
