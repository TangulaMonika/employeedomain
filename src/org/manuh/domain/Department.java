 package org.manuh.domain;

public class Department {

	private String deptName, hod, project;
	private int deptId, workingHours;

	public Department(String deptName, String hod, String project, int deptId, int workingHours) {
		super();
		this.deptName = deptName;
		this.hod = hod;
		this.project = project;
		this.deptId = deptId;
		this.workingHours = workingHours;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", hod=" + hod + ", project=" + project + ", deptId=" + deptId
				+ ", workingHours=" + workingHours + "]";
	}

}
