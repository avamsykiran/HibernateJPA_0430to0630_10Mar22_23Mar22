package com.cts.jpahibdemo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity

/*@Table(name = "all_emps")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")*/

/*@Table(name="base_emps")
@Inheritance(strategy = InheritanceType.JOINED)*/

@Table(name="emps_only")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	@Column(name = "ename", nullable = false)
	private String name;
	private Double basicPay;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String name, Double basicPay) {
		super();
		this.empId = empId;
		this.name = name;
		this.basicPay = basicPay;
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

}
