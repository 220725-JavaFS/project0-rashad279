package com.revature.daos;

import com.revature.models.Finance;

public interface FinanceDAO {
	
	public abstract void getCustomerFinanceInfo(Finance finance);
	
	public abstract void financialDepo(Finance finance);
	
	public abstract void financialWithdraw(Finance finance);
	
	public abstract void financialTransfer(Finance finance);
}
