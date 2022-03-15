package com.cts.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.ContractEmployee;
import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Manager;

public class DemoApplication {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Employee(null, "Vamsy", 56000.0));
		em.persist(new Manager(null, "Navneet", 67000.0, 7890.0));
		em.persist(new ContractEmployee(null, "Kiran", 45000.0, 5.5));
		txn.commit();
		em.close();
	}

}
