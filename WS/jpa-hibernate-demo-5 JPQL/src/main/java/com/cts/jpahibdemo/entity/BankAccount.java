package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class BankAccount {

	@Id
	private String accNum;
	private String ifsc;
	
	@OneToOne
	@JoinColumn(name="empId")
	private Employee holder;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accNum, String ifsc, Employee holder) {
		super();
		this.accNum = accNum;
		this.ifsc = ifsc;
		this.holder = holder;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Employee getHolder() {
		return holder;
	}

	public void setHolder(Employee holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", ifsc=" + ifsc + "]";
	}
	
	
}

