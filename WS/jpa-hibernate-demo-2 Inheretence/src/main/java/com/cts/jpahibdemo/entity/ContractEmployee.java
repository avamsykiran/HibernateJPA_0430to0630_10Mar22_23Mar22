package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("C")
//@Table(name="cemps")
@Table(name="cemps_only")
public class ContractEmployee extends Employee{

	private Double duration;
	
	public ContractEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ContractEmployee(Long empId, String name, Double basicPay,Double duration) {
		super(empId, name, basicPay);
		this.duration=duration;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
	
}
