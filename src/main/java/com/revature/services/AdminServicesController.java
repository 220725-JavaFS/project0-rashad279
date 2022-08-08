package com.revature.services;

import com.revature.daos.AdminDAO;
import com.revature.daos.AdminDAOImpl;
import com.revature.models.Admin;

public class AdminServicesController {

	private AdminDAO adminDao = new AdminDAOImpl();
	
	public void checkAdminLogin(Admin admin) {
		adminDao.validateAdminLogin(admin);
		
	}

}
