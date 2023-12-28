package com.telusko.MappingRelationsInHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		
		List<Laptop> laptops = new ArrayList<>();
		Student student = new Student();
		student.setMarks("55");
		student.setName("Gaurav");
		student.setRollNo(101);
		student.setLaptopList(laptops);
		
		
		
		Laptop laptop = new Laptop();
		laptop.setLid(1);
		laptop.setLname("Dell");
		laptop.setStudent(student);

		


		Laptop laptop1 = new Laptop();
		laptop1.setLid(2); // Unique identifier for laptop1
		laptop1.setLname("Acer");
		laptop1.setStudent(student);

		Laptop laptop2 = new Laptop();
		laptop2.setLid(4); // Unique identifier for laptop2
		laptop2.setLname("Asus");
		laptop2.setStudent(student);

	
		Laptop laptop3 = new Laptop();
		laptop3.setLid(3);
		laptop3.setLname("Yours");
		laptop3.setStudent(student);
		
		laptops.add(laptop1);
		laptops.add(laptop2);
		laptops.add(laptop3);
		laptops.add(laptop);

		

		// Hibernate session setup
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		
		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		
		System.out.println(sessionFactory);

		// Ensure you have separate transactions for different operations

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Save laptops first
		session.save(laptop);
		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);

		// Save student
		session.save(student);

		tx.commit();

		session.close();
	}
}
