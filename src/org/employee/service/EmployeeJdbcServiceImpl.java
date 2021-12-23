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

		PreparedStatement prepStatement;
		try {
			prepStatement = util.getConnection().prepareStatement("select * from employee where empId = ?");
			prepStatement.setInt(1, empId);
			ResultSet rs = prepStatement.executeQuery(); // the query is stored in rs(result set)

			while (rs.next()) {
				e.setEmpId(rs.getInt("empId"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setEmpLastname(rs.getString("empLastname"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setPhone(rs.getLong("phone"));
				e.setSalary(rs.getLong("salary"));
				e.setEmail(rs.getString("email"));
				e.setEmpDesignation(rs.getString("empDesignation"));
				e.setActive(rs.getBoolean("active"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return e;
	}

	@Override
	public List<EmployeeDetails> addEmployee(EmployeeDetails Employee) {
		// TODO Auto-generated method stub
		PreparedStatement prepStatement;
		try {
			prepStatement = util.getConnection().prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?)");
			prepStatement.setInt(1,Employee.getEmpId());
			prepStatement.setString(2,Employee.getEmpFirstname());
			prepStatement.setString(3,Employee.getEmpLastname());
			prepStatement.setLong(4,Employee.getPhone());
			prepStatement.setLong(5,Employee.getSalary());
			prepStatement.setString(6,Employee.getEmail());
			prepStatement.setString(7,Employee.getEmpDesignation());
			prepStatement.setBoolean(8, Employee.isActive());
			prepStatement.setDate(9, null);
			prepStatement.setDate(10,null);
			//ResultSet rs = prepStatement.execute();prepStatement.executeUpdate();
			//return util.addemployee(Employee);
			prepStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		Statement prepStatement;
		try {
			prepStatement = util.getConnection().createStatement();

			ResultSet rs = prepStatement.executeQuery("select * from employee"); // the query is stored in rs(result
																					// set)

			while (rs.next()) {
				e.setEmpId(rs.getInt("empId"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setEmpLastname(rs.getString("empLastname"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setPhone(rs.getLong("phone"));
				e.setSalary(rs.getLong("salary"));
				e.setEmail(rs.getString("email"));
				e.setEmpDesignation(rs.getString("empDesignation"));
				e.setActive(rs.getBoolean("active"));
				employeeList.add(new EmployeeDetails(rs.getInt("empId") , rs.getString("empFirstname") , rs.getString("empLastname"),
						rs.getLong("phone"),rs.getLong("salary"),rs.getString("email"),rs.getString("empDesignation"),rs.getBoolean("active"),null,null));
				 //e.setDateOfJoin(rs.getDate(null));
				 //System.out.println("User ID=" + rs.getInt("empId") + ", Name=" +rs.getString("empFirstname"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;

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
