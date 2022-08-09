package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.revature.models.Customer;
import com.revature.models.Finance;
import com.revature.utils.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	public Finance finance = new Finance();

	public void insertCustomer(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO customers (user_name, pass_word) VALUES (?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, customer.getUserName());
			statement.setString(++count, customer.getPassword());

			statement.execute();
			System.out.println("\nRegistration successful");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}// insertCustomer method

	@Override
	public void validateCustomerLogin(Customer customer) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers WHERE user_name = '"+customer.getUserName()+"' AND "
					+ "pass_word = '"+customer.getPassword()+"';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				customer.setCustomerId(result.getInt("customer_id"));
				customer.setApplicationStatus(result.getString("application_status"));
				
				System.out.println("\nLogin successful");
			}
			else {
				System.out.println("incorrect login! Try again soon.");
			}
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void importCustomerApplication(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customers SET first_name = ?, last_name = ?, str_num = ?, str_name = ?,"
					+ " city = ?, state = ?, zip = ?, application_status = ?"
					+ " WHERE customer_id = '"+customer.getCustomerId()+"';";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, customer.getFirstName());
			statement.setString(++count, customer.getLastName());
			statement.setString(++count, customer.getStrNum());
			statement.setString(++count, customer.getStrName());
			statement.setString(++count, customer.getCity());
			statement.setString(++count, customer.getState());
			statement.setString(++count, customer.getZip());
			statement.setString(++count, customer.getApplicationStatus());
			
			statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	
	
	
	
	
	
}// class
