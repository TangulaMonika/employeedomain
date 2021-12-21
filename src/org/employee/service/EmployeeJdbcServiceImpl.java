package org.employee.service;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.employee.util.JdbcUtil;
import org.manuh.domain.EmployeeDetails;

public class EmployeeJdbcServiceImpl implements EmpService {
	JdbcUtil util = new JdbcUtil();
	EmployeeDetails e = new EmployeeDetails();
	
	

	@Override
	public EmployeeDetails getEmployee(int empId) {
		// TODO Auto-generated method stub
		PreparedStatement prepStatement ;
		try {
			prepStatement  = util.getConnection().prepareStatement("select * from employee where empId = ?");
			prepStatement.setInt(1, empId);
			ResultSet rs = prepStatement .executeQuery(); // the query is stored in rs(result set)
			
			while (rs.next()) {
				
				System.out.println("User ID=" + rs.getInt("empId") + ", Name=" + rs.getString("empFirstname"));
//				
//				return (rs.getInt("empId") + " " + rs.getString("empFirstname") + " " + rs.getString("empLastname") + " " + rs.getLong("phone") + " " +
//						rs.getInt("salary") + " " + rs.getString("email") + " " + rs.getDate("dateOfJoin") + " " + rs.getString("empDesignation") + " " + rs.getBoolean("active")
//						+ " " + rs.getDate("dateOfRelieving"));
// 	}
				
		
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	
	@Override
	public List<EmployeeDetails> addEmployee(EmployeeDetails Employee) {
		// TODO Auto-generated method stub
		PreparedStatement prepStatement ;
		try {
			prepStatement  = util.getConnection().prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?)");
			prepStatement.setInt(1,104);
			prepStatement.setString(2,"Joey");
			prepStatement.setString(3,"Tribbiani");
			prepStatement.setLong(4, 9513246870L);
			prepStatement.setLong(5,50000L);
			prepStatement.setString(6, "joey@gmail.com");
			prepStatement.setString(7,"Developer");
			prepStatement.setBoolean(8,true);
			prepStatement.setDate(9, null);
			prepStatement.setDate(10,null);
			int i = prepStatement.executeUpdate();
			System.out.println(i+" records updated");
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		PreparedStatement prepStatement ;
		try {
			prepStatement  = util.getConnection().prepareStatement("select * from employee");
			//prepStatement.setInt(1, empId);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				System.out.println("User ID=" + rs.getInt("empId") + ", Name=" + rs.getString("empFirstname"));
				
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	
	}

	@Override
	public List<EmployeeDetails> deleteEmployee(EmployeeDetails Employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> topnEmployee(int topn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDetails updateDateOfJoin(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> sortBysalary() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<EmployeeDetails> addEmployee(EmployeeDetails Employee, int empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
