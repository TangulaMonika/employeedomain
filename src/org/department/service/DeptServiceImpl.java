package org.department.service;

import java.util.LinkedList;
import org.manuh.domain.Department;

public class DeptServiceImpl implements DeptService {

	LinkedList<Department> deptList = new LinkedList<>();

	public LinkedList<Department> addDept(Department dept) {
		// TODO Auto-generated method stub
		deptList.add(dept);
		return deptList;
	}

	public LinkedList<Department> getAllDepts() {
		return deptList;
	}

	@Override
	public int getNoOfEmpInaDept(String deptName) {
		// TODO Auto-generated method stub
		int count = 0;
		for (Department i : deptList) {
			if (i.getDeptName() == deptName) {
				count++;
			}
			// return count;
		}
		return count;
		// return (Integer) null;
	}

}
