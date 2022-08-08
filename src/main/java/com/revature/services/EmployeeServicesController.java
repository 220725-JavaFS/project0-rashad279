package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Employee;

public class EmployeeServicesController {
	
	private EmployeeDAO employeeDao = new EmployeeDAOImpl();

	public void checkEmployeeLogin(Employee employee) {
		employeeDao.validateEmployeeLogin(employee);
	}
}
