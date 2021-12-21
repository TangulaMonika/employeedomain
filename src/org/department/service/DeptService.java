package org.department.service;

import java.util.LinkedList;

import org.manuh.domain.Department;

public interface DeptService {

	public LinkedList<Department> addDept(Department dept);

	public LinkedList<Department> getAllDepts();

	public int getNoOfEmpInaDept(String deptName);

}
