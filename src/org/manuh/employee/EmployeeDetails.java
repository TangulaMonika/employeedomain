
package org.manuh.employee;

import java.time.LocalDate;

public class EmployeeDetails {
	private int empId;
	private String empFirstname;
	private String empLastname;
	private String phone;
	private long salary;
	private String email;
	//private Date dob;
	private String empDesignation;
	private boolean active = true;
	private LocalDate dateOfJoin;
	private LocalDate dateOfRelieving;

	public EmployeeDetails(int empId, String empFirstname, String empLastname, String phone, long salary, String email,
			LocalDate dateOfJoin, String empDesignation, boolean active,LocalDate dateOfRelieving) {
		super();
		this.empId = empId;
		this.empFirstname = empFirstname;
		this.empLastname = empLastname;
		this.phone = phone;
		this.salary = salary;
		this.email = email;
		this.dateOfJoin = dateOfJoin;
		this.empDesignation = empDesignation;
		this.active = active;
		this.dateOfRelieving = dateOfRelieving;
	}            

	public LocalDate getDateofrelieving() {
		return dateOfRelieving;
	}

	public void setDateofrelieving(LocalDate dateofrelieving) {
		this.dateOfRelieving = dateofrelieving;
	}

	public EmployeeDetails() {

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstname() {
		return empFirstname;
	}

	public void setEmpFirstname(String empFirstname) {
		this.empFirstname = empFirstname;
	}

	public String getEmpLastname() {
		return empLastname;
	}

	public void setEmpLastname(String empLastname) {
		this.empLastname = empLastname;
	}

	
	public String getEmployeename() {
		return this.empFirstname + " " + this.empLastname;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getdateOfJoin() {
		return dateOfJoin;
	}

	public void setDob(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empFirstname=" + empFirstname + ", empLastname=" + empLastname
				+ ", phone=" + phone + ", salary=" + salary + ", email=" + email + ", empDesignation=" + empDesignation
				+ ", active=" + active + ", dateOfJoin=" + dateOfJoin + ", dateofrelieving=" + dateOfRelieving + "]";
	}

	

}