package org.employee.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.manuh.domain.EmployeeDetails;

public class EmpServiceImpl  implements EmpService {
	
	

		List<EmployeeDetails> EmployeeList = new ArrayList<EmployeeDetails>();

		@Override
		public EmployeeDetails getEmployee(int empId) {
			// TODO Auto-generated method stub
			for(int i =0;i<EmployeeList.size();i++) 
			{
				if (empId==EmployeeList.get(i).getEmpId())
				{
					return EmployeeList.get(i);
				}
				

			}
			
			return null;
		}

		@Override
		public List<EmployeeDetails> addEmployee(EmployeeDetails Employee) {
			// TODO Auto-generated method stub
			EmployeeList.add(Employee);
			return EmployeeList;
			
		}

		@Override
		public List<EmployeeDetails> getAllEmployeeDetails() {
			// TODO Auto-generated method stub
		
			return EmployeeList;
		}

		@Override
		public boolean deleteEmployee(int empId) {
			// TODO Auto-generated method stub
			for(int i =0;i<EmployeeList.size();i++) 
			{
				if (empId==EmployeeList.get(i).getEmpId())
				{
					EmployeeList.remove(EmployeeList.get(i));
					
				}
			
			
			}
			return true;
		}

		@Override
		public List<EmployeeDetails> topnEmployee(int topn) {
			// TODO Auto-generated method stub
			//List<EmployeeDetails> topEmployeeList = new ArrayList<EmployeeDetails>();
			return EmployeeList.subList(0, topn);
			/*for(int i=0;i<=topn;i++) {
				
				topEmployeeList.add(EmployeeList.get(i));
				
				
				
			}
			return topEmployeeList;
	*/	}

		@Override
		public EmployeeDetails updateDateOfJoin(int empId) {
			// TODO Auto-generated method stub
			for(EmployeeDetails Employee : EmployeeList )
			{
				if(Employee.getEmpId() == empId ) {
					Employee.setDateOfJoin(LocalDate.of(2021,12,27));
					return Employee;
				}
			}
			return null;
		}

		@Override
		public List<EmployeeDetails> sortBysalary() {
			// TODO Auto-generated method stub
			Collections.sort(EmployeeList, new Comparator<EmployeeDetails>() { //implementing a comparator interface

				@Override
				public int compare(EmployeeDetails e1, EmployeeDetails e2) {
					// TODO Auto-generated method stub
					if(e1.getSalary()>e2.getSalary())
						return 1;
					return -1;
				}
				
				
					});
			
			return EmployeeList;
		}


		

}