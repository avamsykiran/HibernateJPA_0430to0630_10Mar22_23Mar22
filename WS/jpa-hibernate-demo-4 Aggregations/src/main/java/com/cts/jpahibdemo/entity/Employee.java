package com.cts.jpahibdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Comparable<Employee>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@Column(name = "ename", nullable = false)
	private String name;
	private Double basicPay;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "holder",cascade = CascadeType.ALL)
	private BankAccount salAccount;
	
	@ManyToOne
	@JoinColumn(name = "did")
	private Department dept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String name, Double basicPay, Gender gender, Address address, BankAccount salAccount,
			Department dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.basicPay = basicPay;
		this.gender = gender;
		this.address = address;
		this.salAccount = salAccount;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basicPay=" + basicPay + ", gender=" + gender
				+ ", address=" + address + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId==null?1:this.empId.compareTo(o.empId);
	}

}
