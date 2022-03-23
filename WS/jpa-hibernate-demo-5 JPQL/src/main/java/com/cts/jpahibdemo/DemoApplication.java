package com.cts.jpahibdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Gender;
import com.cts.jpahibdemo.entity.Trainee;
import com.cts.jpahibdemo.model.DeptWiseEmpCount;

public class DemoApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		Query q1 = em.createQuery("SELECT t FROM Trainee t");
		q1.getResultStream().forEach(System.out::println);

		TypedQuery q2 = em.createQuery("SELECT t FROM Trainee t", Trainee.class);
		q2.getResultStream().forEach(System.out::println);

		Query q3 = em.createQuery("SELECT e.name,e.dept.title FROM Employee e");
		List<Object[]> recs = q3.getResultList();
		for (Object[] rec : recs) {
			System.out.println(String.format("%s\t%s", rec[0], rec[1]));
		}

		Query q4 = em.createQuery("SELECT c.artist.name,c.movie.title,c.role FROM Cast c order by c.movie.title");
		List<Object[]> recs4 = q4.getResultList();
		for (Object[] rec : recs4) {
			System.out.println(String.format("%s\t%s\t%s", rec[0], rec[1], rec[2]));
		}

		TypedQuery q5 = em.createQuery(String.format("SELECT e FROM Employee e WHERE e.gender='%s'", Gender.GENT),
				Employee.class);
		q5.getResultStream().forEach(System.out::println);

		Query q6 = em.createQuery("SELECT e.dept.title,COUNT(e) FROM Employee e GROUP BY e.dept.title");
		List<Object[]> recs6 = q6.getResultList();
		for (Object[] rec : recs6) {
			System.out.println(String.format("%s\t%s", rec[0], rec[1]));
		}

		Query q7 = em.createQuery(
				"SELECT d.title,COUNT(e) FROM Department d LEFT JOIN Employee e ON d=e.dept GROUP BY d.title");
		List<Object[]> recs7 = q7.getResultList();
		for (Object[] rec : recs7) {
			System.out.println(String.format("%s\t%s", rec[0], rec[1]));
		}

		TypedQuery q8 = em.createQuery(
				// "SELECT d.title as deptName,COUNT(e) as empCount FROM Department d LEFT JOIN Employee e ON d=e.dept GROUP BY d.title",
				"SELECT new com.cts.jpahibdemo.model.DeptWiseEmpCount(d.title,COUNT(e)) FROM Department d LEFT JOIN Employee e ON d=e.dept GROUP BY d.title",
				DeptWiseEmpCount.class);
		q8.getResultStream().forEach(System.out::println);

		//positional paramatrized query
		TypedQuery<Employee> q9 = em.createQuery("SELECT e FROM Employee e WHERE e.gender=?1", Employee.class);
		q9.setParameter(1, Gender.GENT);
		q9.getResultStream().forEach(System.out::println);
		q9.setParameter(1, Gender.LADY);
		q9.getResultStream().forEach(System.out::println);

		//named paramatrized query
		TypedQuery<Employee> q10 = em.createQuery("SELECT e FROM Employee e WHERE e.gender=:gender", Employee.class);
		q10.setParameter("gender", Gender.GENT);
		q10.getResultStream().forEach(System.out::println);
		q10.setParameter("gender", Gender.LADY);
		q10.getResultStream().forEach(System.out::println);
		
		TypedQuery<Employee> q11 = em.createNamedQuery("EMP_SAL_RANGE", Employee.class);
		q11.setParameter("lower", 1200.0);
		q11.setParameter("upper", 7500.0);
		q11.getResultStream().forEach(System.out::println);
		
		em.close();
	}
}
