package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

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

}
