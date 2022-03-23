package com.cts.jpahibdemo.model;

public class DeptWiseEmpCount {

	private String deptName;
	private int empCount;
	
	public DeptWiseEmpCount() {
		// TODO Auto-generated constructor stub
	}

	public DeptWiseEmpCount(String deptName, long empCount) {
		super();
		this.deptName = deptName;
		this.empCount = (int)empCount;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	@Override
	public String toString() {
		return "DeptWiseEmpCount [deptName=" + deptName + ", empCount=" + empCount + "]";
	}
	
	
}
