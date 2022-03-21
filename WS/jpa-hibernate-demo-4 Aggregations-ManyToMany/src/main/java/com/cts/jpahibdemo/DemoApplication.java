package com.cts.jpahibdemo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Artist;
import com.cts.jpahibdemo.entity.Cast;
import com.cts.jpahibdemo.entity.Movie;
import com.cts.jpahibdemo.entity.Trainee;
import com.cts.jpahibdemo.entity.TraineeId;

public class DemoApplication {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		Artist a1 = new Artist(null, "Sharukh Khan");
		Artist a2 = new Artist(null, "Aishwarya Rai");
		Artist a3 = new Artist(null, "Hrithik Roshan");
		
		Movie m1 = new Movie(null,"Dhoom 3");
		Movie m2 = new Movie(null,"Mohabattein");
		
		Cast c1 = new Cast(m1,a3,"Hero");
		Cast c2 = new Cast(m1,a2,"Heroine");
		Cast c3 = new Cast(m2,a2,"Heroine");
		Cast c4 = new Cast(m2,a1,"Hero");
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(m1);
		em.persist(m2);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		
		em.persist(new Trainee(new TraineeId(1L, "JavaFSD"),"Vamsy Kiran", LocalDate.now()));
		em.persist(new Trainee(new TraineeId(1L, "MERN-FSD"),"Suseela", LocalDate.now()));
		em.persist(new Trainee(new TraineeId(1L, "MEAN-FSD"),"Indhikaa", LocalDate.now()));
		txn.commit();
		em.close();
	}
}
