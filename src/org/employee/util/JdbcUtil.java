package org.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.manuh.domain.EmployeeDetails;

public class JdbcUtil {
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "tmo@manuh9");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!" + e.getMessage());
			e.printStackTrace();
		}
		return connection;

	}

//	public List<EmployeeDetails> executeStatement(String query) throws SQLException {
//		Statement stmt = getConnection().createStatement();
//		ResultSet rs = stmt.executeQuery("select * from employee"); // the query is stored in rs(result set)
//		while (rs.next()) {
//			System.out.println("User ID=" + rs.getInt("empId") + ", Name=" + rs.getString("empFirstname"));
//		}
//		return null;
//	}

	public List<EmployeeDetails> addemployee(EmployeeDetails employee)   {
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("insert into employee values ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return null;
	}
}
