package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public Finance finance = new Finance();
	@Override
	public void validateEmployeeLogin(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employees WHERE user_name = '"+employee.getUserName()+"' AND "
					+ "pass_word = '"+employee.getPassword()+"';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				employee.setEmployeeId(result.getInt("employee_id"));
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
	public List<Customer> getApplications() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers WHERE application_status = 'applied';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Customer> applicationList = new LinkedList <>();
			
			while(result.next()) { 
				Customer customer = new Customer(
						result.getInt("customer_id"),
						result.getString("user_name"),
						result.getString("pass_word"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("str_num"),
						result.getString("str_name"),
						result.getString("city"),
						result.getString("state"),
						result.getString("zip"),
						result.getString("application_status")
						);
				
				applicationList.add(customer);
				
			}//while loop
			
			return applicationList;
		}//try 
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void updateCustomerApplication(Customer customer) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customers SET application_status = ?"
					+ " WHERE customer_id = ? ;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, customer.getApplicationStatus());
			statement.setInt(++count, customer.getCustomerId());
			
			statement.execute();
			
			System.out.println("application status updated");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createFinancialAcct(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO finances (customer_id, account_balance) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(sql);
	
			int count = 0;
			double startBalance = 0.00d;
			statement.setInt(++count, customer.getCustomerId());
			statement.setDouble(++count, startBalance);
			statement.execute();
			
			finance.setAccountBalance(startBalance); 
			
			System.out.println("new financial account created");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}



	
	

}
