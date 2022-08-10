package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;
import com.revature.utils.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO {

	private Customer customer = new Customer();
	private Finance finance = new Finance();
	@Override
	
	public void validateAdminLogin(Admin admin) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM admins WHERE user_name = '"+admin.getUserName()+"' AND "
					+ "pass_word = '"+admin.getPassword()+"';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				admin.setAdminId(result.getInt("admin_id"));
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
	public void importNewEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO employees (user_name, pass_word) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, employee.getUserName());
			statement.setString(++count, employee.getPassword());
			
			statement.execute();
			
			System.out.println("new employee created!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List <Employee> adminViewEmployeeAccts(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employees;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Employee> employeeList = new LinkedList <>();
			
			
				while(result.next()) { 
			
					Employee employee1 = new Employee(
						result.getInt("employee_id"),
						result.getString("user_name"),
						result.getString("pass_word")
						);
				
				employeeList.add(employee1);
				}
			return employeeList;
		}//try 
		catch(SQLException e) {
			e.printStackTrace();
		}//catch
		return null;
	}
		

	@Override
	public void changeEmployeeLogin(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE employees SET user_name = ?, pass_word = ?, WHERE employee_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, employee.getUserName());
			statement.setString(++count, employee.getPassword());
			statement.setInt(++count, employee.getEmployeeId());
			statement.execute();
			
			System.out.println("employee updated!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM employees WHERE employee_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setInt(++count, employee.getEmployeeId());
			statement.execute();
			
			System.out.println("employee removed!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeCustomAddr(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customers SET first_name = ?, last_name = ?, str_num = ?, str_name = ?, city = ?, state = ?, zip = ?"
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
			
			statement.execute();
			
			System.out.println("Customer name and address has been updated!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterCustomerLogin(Customer customer) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customers SET user_name = ?, pass_word = ?, WHERE employee_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, customer.getUserName());
			statement.setString(++count, customer.getPassword());
			statement.setInt(++count, customer.getCustomerId());
			statement.execute();
			
			System.out.println("customer login updated!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void changeCustomerAcctBal(Finance finance) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE finances SET account_balance = ? WHERE customer_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setDouble(++count, finance.getAccountBalance());
			statement.setInt(++count, finance.getCustomerId());
			statement.execute();
			
			System.out.println("account balance updated!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeCustomerAcct(Finance finance) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM finances WHERE customer_id = ?; DELETE FROM customers WHERE customer_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setInt(++count, finance.getCustomerId());
			statement.setInt(++count, finance.getCustomerId());
			statement.execute();
			
			System.out.println("customer fully removed!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
