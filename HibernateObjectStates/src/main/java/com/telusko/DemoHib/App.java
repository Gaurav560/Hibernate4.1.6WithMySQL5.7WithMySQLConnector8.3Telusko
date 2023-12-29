package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	public static void main(String[] args) {

		

		
		
		
		//session object created
		Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class);
		
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionfactory=con.buildSessionFactory(reg);
		System.out.println(sessionfactory);
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		//load gives proxy object.it willnot give original object untill that object is used somewhere in the poject.
		//where as save method gives actual object.save throwa null when the object is not present where as load
		//throws object not found exception .
		
		Laptop l=(Laptop)session.load(Laptop.class, 55);
		
		System.out.println(l);
		
		
		
		
		
		
		
		
		
		
		/*
		 * Laptop l=new Laptop(); l.setBrand("Sony"); l.setPrice(50000); l.setLid(56);
		 * 
		 * //session.save(l); l.setPrice(796968676);
		 * 
		 * session.delete(l);
		 * 
		 * session.getTransaction().commit(); //when u evict an object from session
		 * changes made to the object are not persisted in the database
		 * 
		 * session.evict(l); l.setPrice(4565654);
		 */
		session.getTransaction().commit();
	}
}
