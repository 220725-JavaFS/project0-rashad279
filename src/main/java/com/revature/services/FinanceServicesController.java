package com.revature.services;

import com.revature.daos.FinanceDAO;
import com.revature.daos.FinanceDAOImpl;
import com.revature.models.Finance;

public class FinanceServicesController {

	FinanceDAO financeDao = new FinanceDAOImpl();
	
	public void getCustomerFinanceInformation(Finance finance) {
		financeDao.getCustomerFinanceInfo(finance);
	}

	public void financialDeposit(Finance finance) {
		financeDao.financialDepo(finance);
		
	}

	public void financialWithdrawal(Finance finance) {
		financeDao.financialWithdraw(finance);
		
	}

	public void financialTransferFunds(Finance finance) {
		financeDao.financialTransfer(finance);
		
	}
}
