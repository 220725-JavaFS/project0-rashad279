package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Finance;
import com.revature.utils.ConnectionUtil;

public class FinanceDAOImpl implements FinanceDAO {

	@Override
	public void getCustomerFinanceInfo(Finance finance) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM finances WHERE customer_id = '"+finance.getCustomerId()+"';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				finance.setAccountNum(result.getInt("account_num"));
				finance.setAccountBalance(result.getDouble("account_balance"));
				
				
				System.out.println("\nWelcome To Your Financial Account");
			}
			else {
				System.out.println("\nCant access financial information");
			}
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public void financialDepo(Finance finance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void financialWithdraw(Finance finance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void financialTransfer(Finance finance) {
		// TODO Auto-generated method stub
		
	}
	
	

}// class
