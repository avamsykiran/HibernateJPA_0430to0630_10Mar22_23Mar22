package com.cts.jpahibdemo;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cts.jpahibdemo.entity.Book;

public class DemoApplication {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(new Book(null, "Let Us C", 3000.0, LocalDate.now()));
		session.save(new Book(null, "Let Us C++", 4000.0, LocalDate.now()));
		session.save(new Book(null, "Java Head First", 5000.0, LocalDate.now()));
		session.save(new Book(null, "Complete Reference - Java", 6000.0, LocalDate.now()));
		
		txn.commit();
		
		session.close();
		sf.close();
		
	}
}
