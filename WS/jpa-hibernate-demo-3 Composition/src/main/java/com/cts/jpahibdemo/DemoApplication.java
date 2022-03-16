package com.cts.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Address;
import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Gender;

public class DemoApplication {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Employee(null, "Vamsy", 67000.0, Gender.GENT, new Address("VSP", "AP")));
		em.persist(new Employee(null, "Umman", 67000.0, Gender.LADY, new Address("COCHI", "KERALA")));
		em.persist(new Employee(null, "Selva", 67000.0, Gender.GENT, new Address("CHENNAI", "TN")));
		txn.commit();
		em.close();
	}
}
