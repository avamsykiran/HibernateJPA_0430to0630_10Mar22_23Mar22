package com.cts.jpahibdemo;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Address;
import com.cts.jpahibdemo.entity.BankAccount;
import com.cts.jpahibdemo.entity.Department;
import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Gender;

public class DemoApplication {

	public static void main(String[] args) {
		
		Department d1 = new Department(null, "Java FSD", new TreeSet<Employee>());
		Department d2 = new Department(null, "DotNet FSD", new TreeSet<Employee>());
		Department d3 = new Department(null, "MEAN FSD", new TreeSet<Employee>());
		
		Employee e1 = new Employee(null, "Vamsy", 6700.0, Gender.GENT, 
				new Address("VIZAG", "AP"), null, d1);
		d1.getEmps().add(e1);
		e1.setSalAccount(new BankAccount("SB1001", "SBI0006767", e1));
		
		Employee e2 = new Employee(null, "Suma", 6700.0, Gender.LADY, 
				new Address("HYD", "TNG"), null, d2);
		d2.getEmps().add(e2);
		e2.setSalAccount(new BankAccount("SB1002", "SBI0006767", e2));
		
		Employee e3 = new Employee(null, "Varun", 6700.0, Gender.GENT, 
				new Address("CHENNAI", "TN"), null, d2);
		d2.getEmps().add(e3);
		e3.setSalAccount(new BankAccount("SB1003", "SBI0006767", e3));
		
		Employee e4 = new Employee(null, "Vanitha", 6700.0, Gender.LADY, 
				new Address("BLR", "KARNATAKA"), null, d1);
		d1.getEmps().add(e4);
		e4.setSalAccount(new BankAccount("SB1004", "SBI0006767", e4));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		txn.commit();
		em.close();
	}
}
