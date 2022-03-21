package com.cts.jpahibdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpahibdemo.entity.Trainee;

public class DemoApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		Query q1 = em.createQuery("SELECT t FROM Trainee t");
		q1.getResultStream().forEach(System.out::println);
		
		TypedQuery q2 = em.createQuery("SELECT t FROM Trainee t",Trainee.class);
		q2.getResultStream().forEach(System.out::println);

		Query q3 = em.createQuery("SELECT e.name,e.dept.title FROM Employee e");
		List<Object[]> recs = q3.getResultList();
		for(Object[] rec : recs) {
			System.out.println(String.format("%s\t%s", rec[0],rec[1]));
		}
		
		Query q4 = em.createQuery(
				"SELECT c.artist.name,c.movie.title,c.role FROM Cast c order by c.movie.title");
		List<Object[]> recs4 = q4.getResultList();
		for(Object[] rec : recs4) {
			System.out.println(String.format("%s\t%s\t%s", rec[0],rec[1],rec[2]));
		}
		
		em.close();
	}
}
