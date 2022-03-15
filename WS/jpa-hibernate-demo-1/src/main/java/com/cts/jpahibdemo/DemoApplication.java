package com.cts.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Department;

public class DemoApplication {

	public static void main(String[] args) {
		
		//transiant state
		Department d1 = new Department(null, "Accounts");
		Department d2 = new Department(null, "HR");
		Department d3 = new Department(null, "Operations");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		 //d1,d2 and d3 are in persistant state.
		
		d2.setTitle("Human Resource");
		txn.commit();
		em.close();
		//d1,d2 and d3 are in detached state
		
		
	}

}
