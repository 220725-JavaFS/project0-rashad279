package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Admin;
import com.revature.utils.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO {

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

}
