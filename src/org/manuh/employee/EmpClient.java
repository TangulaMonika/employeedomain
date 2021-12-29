package org.manuh.employee;

import java.time.LocalDate;

import org.department.service.DeptJdbcServiceImpl;
import org.department.service.DeptService;
import org.department.service.DeptServiceImpl;
import org.department.util.DeptJdbcUtil;
import org.employee.service.EmpService;
import org.employee.service.EmpServiceImpl;
import org.employee.service.EmployeeJdbcServiceImpl;
import org.employee.util.JdbcUtil;
import org.manuh.domain.Department;
import org.manuh.domain.EmployeeDetails;

public class EmpClient {

	public static void main(String args[]) {

		EmployeeDetails emp = new EmployeeDetails(101, "Chandler", "Bing", 987654321L, 50000L, "bing@gmail.com",
				"Manager", true, LocalDate.of(2018, 03, 12), LocalDate.now());
		EmployeeDetails emp1 = new EmployeeDetails(102, "Monica", "Bing", 9876783210L, 45000L, "monica@gmail.com",
				"Developer", false, LocalDate.of(2015, 05, 12), LocalDate.now());
		EmployeeDetails emp2 = new EmployeeDetails(103, "Ross", "Geller", 9876712210L, 35000, "ross@gmail.com",
				"Tester", true, LocalDate.now(), LocalDate.of(2017, 04, 13));
		EmployeeDetails emp3 = new EmployeeDetails(104, "Rachel", "Geller", 9876712210L, 15000, "ross@gmail.com",
				"Tester", true, LocalDate.now(), LocalDate.now());
		EmployeeDetails emp4 = new EmployeeDetails(105, "Joey", "Tribbiani", 9876712210L, 15000, "joey@gmail.com",
				"Developer", true, LocalDate.now(), LocalDate.now());
		EmployeeDetails emp5 = new EmployeeDetails(106, "Pheobe", "Buffay", 9876712210L, 35000, "phoebe@gmail.com",
				"Manager", false, LocalDate.now(), LocalDate.now());
		EmployeeDetails emp6 = new EmployeeDetails(107, "Mike", "Buffay", 9876712210L, 45000, "mike@gmail.com", "Admin",
				false, LocalDate.of(2001, 04, 15), LocalDate.now());

		EmpService service = new EmpServiceImpl();
		service.addEmployee(emp);
		service.addEmployee(emp1);
		service.addEmployee(emp2);
		service.addEmployee(emp3);
		service.addEmployee(emp4);
		service.addEmployee(emp5);
		service.addEmployee(emp6);
		service.getAllEmployeeDetails();
		
		Department dept = new Department("IT", "Nishita", "Employee management project", 201, 13);
		Department dept1 = new Department("Admin", "Monika", "Product management project", 202, 12);
		Department dept2 = new Department("Business", "Pravallika", "Student management project", 203, 15);
		Department dept3 = new Department("Non-Tech", "Praneeth", "online banking management project", 204, 12);
		Department dept4 = new Department("Admin", "Pardhu", "Employee management project", 205, 13);
		Department dept5 = new Department("Non-Tech", "Satish", "Product management project", 206, 12);
		Department dept6 = new Department("Business", "Aravind", "Student management project", 207, 12);

		// System.out.println(service.getAllEmployeeDetails());
		// service.deleteEmployee(emp);
		// System.out.println(service.getAllEmployeeDetails());
		// System.out.println(service.getEmployee(102));
//		System.out.println(service.updateDateOfJoin(102));
//		System.out.println("Topnemployee beginning");
//		System.out.println(service.topnEmployee(2));
//		System.out.println("Topnemployee end");
//		System.out.println(service.sortBysalary());
//		JdbcUtil obj = new JdbcUtil();
//		EmployeeJdbcServiceImpl obj1 = new EmployeeJdbcServiceImpl();
//		 System.out.println(obj1.getEmployee(102));
		//System.out.println(obj1.getAllEmployeeDetails());
		//System.out.println(obj1.addEmployee(emp6));
//		obj1.deleteEmployee(107);
//
//		// System.out.println(obj1.getAllEmployeeDetails());
//		System.out.println(obj1.topnEmployee(2));
//		System.out.println(obj1.getAllEmployeeDetails());
//		System.out.println(obj1.updateDateOfJoin(102));
//		System.out.println(obj1.sortBysalary());

//		try {
//			obj.executeStatement("select * from employee");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		DeptService service1 = new DeptServiceImpl();
		service1.addDept(dept);
		service1.addDept(dept1);
		service1.addDept(dept2);
		service1.addDept(dept3);
		service1.addDept(dept4);
		service1.addDept(dept5);
		service1.addDept(dept6);
		service1.getAllDepts();
		
		DeptJdbcUtil var = new DeptJdbcUtil();
		DeptJdbcServiceImpl var1 = new DeptJdbcServiceImpl();
//		System.out.println(var1.addDept(dept6));
//		System.out.println(service1.getAllDepts());
		System.out.println(service1.getNoOfEmpInaDept("Non-Tech"));


	}
}
