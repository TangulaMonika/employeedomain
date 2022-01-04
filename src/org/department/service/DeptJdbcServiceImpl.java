package org.department.service;

import java.util.LinkedList;

import org.department.util.DeptJdbcUtil;
import org.employee.util.JdbcUtil;
import org.manuh.domain.Department;

public class DeptJdbcServiceImpl implements DeptService {
	DeptJdbcUtil jdbc = new DeptJdbcUtil();


	@Override
	public LinkedList<Department> addDept(Department dept) {
		// TODO Auto-generated method stub
		return jdbc.addDept(dept);
	}

	@Override
	public LinkedList<Department> getAllDepts() {
		// TODO Auto-generated method stub
		return jdbc.getAllDepts();
	}

	@Override
	public int getNoOfEmpInaDept(String deptName) {
		// TODO Auto-generated method stub
		return jdbc.getNoOfEmpInaDept(deptName);
	}
	

}
