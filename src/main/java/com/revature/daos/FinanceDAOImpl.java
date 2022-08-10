package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE finances SET account_balance = account_balance + ? WHERE account_num = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setDouble(++count, finance.getDeposit());
			statement.setInt(++count, finance.getAccountNum());
			
			statement.execute();
			
			System.out.println("\nDeposit Complete");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void financialWithdraw(Finance finance) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE finances SET account_balance = account_balance - ? WHERE account_num = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setDouble(++count, finance.getWithdraw());
			statement.setInt(++count, finance.getAccountNum());
			
			statement.execute();
			
			System.out.println("\nWithdraw Complete");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void financialTransfer(Finance finance) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE finances SET account_balance = account_balance - ? WHERE account_num = ?; "
					+ "UPDATE finances SET account_balance = account_balance + ? WHERE account_num = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setDouble(++count, finance.getFundsToTransfer());
			statement.setInt(++count, finance.getAccountNum());
			statement.setDouble(++count, finance.getFundsToTransfer());
			statement.setInt(++count, finance.getAccountNumReceivingTransfer());
			statement.execute();
			
			System.out.println("\nTransfer Complete");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}// class
