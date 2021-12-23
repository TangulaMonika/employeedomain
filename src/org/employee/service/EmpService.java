package org.employee.service;

import java.util.List;

import org.manuh.domain.EmployeeDetails;


public interface EmpService {
	
	public EmployeeDetails getEmployee(int empId);

	public List<EmployeeDetails> addEmployee(EmployeeDetails Employee );
	
	public List<EmployeeDetails> getAllEmployeeDetails();
	
	public List<EmployeeDetails> deleteEmployee( EmployeeDetails Employee);
	
	public List<EmployeeDetails> topnEmployee( int topn);
	
	public EmployeeDetails updateDateOfJoin(int empId);
	
	public List<EmployeeDetails> sortBysalary();

	List<EmployeeDetails> addEmployee(EmployeeDetails Employee, int empId);
	

}
