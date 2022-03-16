package com.cts.jpahibdemo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "emps")
public class Employee {

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

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String name, Double basicPay, Gender gender, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.basicPay = basicPay;
		this.gender = gender;
		this.address = address;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basicPay=" + basicPay + ", gender=" + gender
				+ ", address=" + address + "]";
	}

}
