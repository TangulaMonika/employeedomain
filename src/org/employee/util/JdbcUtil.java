package org.employee.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.manuh.domain.EmployeeDetails;

public class JdbcUtil {
	EmployeeDetails e = new EmployeeDetails();

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

	public List<EmployeeDetails> executeStatement(String query) throws SQLException {
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee"); // the query is stored in rs(result set)
		while (rs.next()) {
			System.out.println("User ID=" + rs.getInt("empId") + ", Name=" + rs.getString("empFirstname"));
		}
		return null;
	}

	public List<EmployeeDetails> addEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?)");
			prepStatement.setInt(1, employee.getEmpId());
			prepStatement.setString(2, employee.getEmpFirstname());
			prepStatement.setString(3, employee.getEmpLastname());
			prepStatement.setLong(4, employee.getPhone());
			prepStatement.setLong(5, employee.getSalary());
			prepStatement.setString(6, employee.getEmail());
			prepStatement.setString(7, employee.getEmpDesignation());
			prepStatement.setBoolean(8, employee.isActive());
			prepStatement.setDate(9, Date.valueOf(employee.getDateOfJoin()));
			prepStatement.setDate(10, Date.valueOf(employee.getDateOfRelieving()));
			// ResultSet rs = prepStatement.execute();prepStatement.executeUpdate();
			// return util.addemployee(Employee);
			prepStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public EmployeeDetails getEmployee(int empId) {
		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("select * from employee where empId = ?");
			prepStatement.setInt(1, empId);
			ResultSet rs = prepStatement.executeQuery(); // the query is stored in rs(result set)

			while (rs.next()) {
				java.sql.Date joinDate = rs.getDate("dateOfJoin");
				java.sql.Date RelievingDate1 = rs.getDate("dateOfRelieving");
				LocalDate dateOfJoin = joinDate.toLocalDate();
				LocalDate RelievingDate = RelievingDate1.toLocalDate();
				
				e.setEmpId(rs.getInt("empId"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setEmpLastname(rs.getString("empLastname"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setPhone(rs.getLong("phone"));
				e.setSalary(rs.getLong("salary"));
				e.setEmail(rs.getString("email"));
				e.setEmpDesignation(rs.getString("empDesignation"));
				e.setActive(rs.getBoolean("active"));
				e.setDateOfJoin(dateOfJoin);
				e.setDateOfRelieving(RelievingDate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return e;
	}

	public boolean deleteEmployee(int empId) {

		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("delete from employee where empId = ?");
			prepStatement.setInt(1, empId);
			prepStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public List<EmployeeDetails> getAllEmployees() {
		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		Statement prepStatement;
		try {
			prepStatement = getConnection().createStatement();

			ResultSet rs = prepStatement.executeQuery("select * from employee"); // the query is stored in rs(result
																					// set)

			while (rs.next()) {
				java.sql.Date joinDate = rs.getDate("dateOfJoin");
				java.sql.Date RelievingDate1 = rs.getDate("dateOfRelieving");
				LocalDate dateOfJoin = joinDate.toLocalDate();
				RelievingDate1.toLocalDate();
				LocalDate dateOfRelieving = LocalDate.now();

				employeeList.add(new EmployeeDetails(rs.getInt("empId"), rs.getString("empFirstname"),
						rs.getString("empLastname"), rs.getLong("phone"), rs.getLong("salary"), rs.getString("email"),
						rs.getString("empDesignation"), rs.getBoolean("active"), dateOfJoin, dateOfRelieving));
				// e.setDateOfJoin(rs.getDate(null));
				// System.out.println("User ID=" + rs.getInt("empId") + ", Name="
				// +rs.getString("empFirstname"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;
	}

	public List<EmployeeDetails> topnEmployee(int topn) {
		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("select * from employee order by salary desc limit ?");

			// ResultSet rs = prepStatement.executeQuery("select top ? from employee)");
			prepStatement.setInt(1, topn);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				java.sql.Date joinDate = rs.getDate("dateOfJoin");
				java.sql.Date RelievingDate1 = rs.getDate("dateOfRelieving");
				LocalDate dateOfJoin = joinDate.toLocalDate();
				RelievingDate1.toLocalDate();
				LocalDate dateOfRelieving = LocalDate.now();

				employeeList.add(new EmployeeDetails(rs.getInt("empId"), rs.getString("empFirstname"),
						rs.getString("empLastname"), rs.getLong("phone"), rs.getLong("salary"), rs.getString("email"),
						rs.getString("empDesignation"), rs.getBoolean("active"), dateOfJoin, dateOfRelieving));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	public EmployeeDetails updateDateOfJoin(int empId) {
		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("update employee set dateOfJoin = ? where empId = ?");

			// ResultSet rs = prepStatement.executeQuery("select top ? from employee)");
			//prepStatement.setInt(1, salary);
			prepStatement.setDate(1, Date.valueOf(LocalDate.now()) );
			prepStatement.setInt(2, empId);
			prepStatement.execute();
			
			
			//after update query
			prepStatement = getConnection().prepareStatement("select * from employee where empId = ?");
			prepStatement.setInt(1, empId);
			ResultSet rs = prepStatement.executeQuery(); // the query is stored in rs(result set)

			while (rs.next()) {
				java.sql.Date joinDate = rs.getDate("dateOfJoin");
				java.sql.Date RelievingDate1 = rs.getDate("dateOfRelieving");
				LocalDate dateOfJoin = joinDate.toLocalDate();
				LocalDate RelievingDate = RelievingDate1.toLocalDate();
				
			
				e.setEmpId(rs.getInt("empId"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setEmpLastname(rs.getString("empLastname"));
				e.setEmpFirstname(rs.getString("empFirstname"));
				e.setPhone(rs.getLong("phone"));
				e.setSalary(rs.getLong("salary"));
				e.setEmail(rs.getString("email"));
				e.setEmpDesignation(rs.getString("empDesignation"));
				e.setActive(rs.getBoolean("active"));
				e.setDateOfJoin(dateOfJoin);
				e.setDateOfRelieving(RelievingDate);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e;
	}

	public List<EmployeeDetails> sortBysalary() {
		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		PreparedStatement prepStatement;
		try {
			prepStatement = getConnection().prepareStatement("select * from employee order by salary ASC");
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				java.sql.Date joinDate = rs.getDate("dateOfJoin");
				java.sql.Date RelievingDate1 = rs.getDate("dateOfRelieving");
				LocalDate dateOfJoin = joinDate.toLocalDate();
				LocalDate RelievingDate = RelievingDate1.toLocalDate();
				

				employeeList.add(new EmployeeDetails(rs.getInt("empId"), rs.getString("empFirstname"),
						rs.getString("empLastname"), rs.getLong("phone"), rs.getLong("salary"), rs.getString("email"),
						rs.getString("empDesignation"), rs.getBoolean("active"), dateOfJoin, RelievingDate));

	}
}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	}
