package org.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public void insert(EmployeeDetails employee) {
		String Query = "insert into employee values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prep = getConnection().prepareStatement("Query");
			prep.setInt(1,employee.getEmpId());
			prep.setString(2,employee.getEmpFirstname());
			prep.setString(3,employee.getEmpLastname());
			prep.setLong(4,employee.getPhone());
			prep.setLong(5,employee.getSalary());
			prep.setString(6,employee.getEmail());
			prep.setString(7,employee.getEmpDesignation());
			prep.setBoolean(8,employee.isActive());
			//prep.setDate(9, employee.getDateOfJoin());
		//	prep.setDate(10, employee.getDateOfRelieving());
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getEmployee(int empId) {
		String Query = "select * from employee where empId = ?";
		try {
			PreparedStatement prep = getConnection().prepareStatement("Query");
			prep.setInt(1, empId);
			prep.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empId;
		
	}

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
