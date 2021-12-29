package org.department.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.manuh.domain.Department;

import com.mysql.cj.xdevapi.Result;

public class DeptJdbcUtil {
	
	LinkedList<Department> deptList = new LinkedList<>();

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

	public LinkedList<Department> addDept(Department dept) {
		PreparedStatement prepStatement;
		try {

			prepStatement = getConnection().prepareStatement("insert into department values (?,?,?,?,?)");
			prepStatement.setString(1, dept.getDeptName());
			prepStatement.setString(2, dept.getHod());
			prepStatement.setString(3, dept.getProject());
			prepStatement.setInt(4, dept.getDeptId());
			prepStatement.setInt(5, dept.getWorkingHours());

			prepStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
	}

	public LinkedList<Department> getAllDepts() {
		Statement prepStatement;
		try {
			prepStatement = getConnection().createStatement();
			ResultSet rs = prepStatement.executeQuery("select * from department;");
			
			deptList.add(new Department(rs.getString("deptName"),rs.getString("hod"),rs.getString("Project"),rs.getInt("deptId"),rs.getInt("workingHours")));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return deptList;
	}

	public Department getNoOfEmpInaDept(String deptName) {
		Department dep = new Department();
		PreparedStatement prp;
		try {
		prp = getConnection().prepareStatement("select * from department where deptName = ?");
		prp.setString(1, deptName);
		ResultSet rs = prp.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dep;

	}
}
