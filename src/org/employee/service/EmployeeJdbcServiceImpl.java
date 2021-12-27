package org.employee.service;

import java.util.List;

import org.employee.util.JdbcUtil;
import org.manuh.domain.EmployeeDetails;

public class EmployeeJdbcServiceImpl implements EmpService {
	JdbcUtil util = new JdbcUtil();

	@Override
	public EmployeeDetails getEmployee(int empId) {
		// TODO Auto-generated method stub
		return util.getEmployee(empId);
	}

	@Override
	public List<EmployeeDetails> addEmployee(EmployeeDetails Employee) {
		// TODO Auto-generated method stub
		return util.addEmployee(Employee);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return util.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return util.deleteEmployee(empId);
	}

	@Override
	public List<EmployeeDetails> topnEmployee(int topn) {
		// TODO Auto-generated method stub
		return util.topnEmployee(topn);
	}

	@Override
	public EmployeeDetails updateDateOfJoin(int empId) {
		// TODO Auto-generated method stub
		return util.updateDateOfJoin(empId);
	}

	@Override
	public List<EmployeeDetails> sortBysalary() {
		// TODO Auto-generated method stub
		return util.sortBysalary();
	}

}
