package com.telusko.FetchEagerLazy;

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

		Alien alien1 = new Alien();
		Alien alien2 = new Alien();
		Alien alien3 = new Alien();
		List<Laptop> laptops=new ArrayList<>();
		
		Laptop laptop = new Laptop();
		laptop.setLid(1);
		laptop.setPrice("344");
		laptop.setBrand("Kyzer");
		laptop.setAlien(alien1);
		
		Laptop laptop1 = new Laptop();
		laptop1.setLid(12);
		laptop1.setPrice("344");
		laptop1.setBrand("Ktkht");
		laptop1.setAlien(alien1);
		
	
		
		Laptop laptop2 = new Laptop();
		laptop2.setLid(2);
		laptop2.setPrice("344");
		laptop2.setBrand("Kyzer");
		laptop2.setAlien(alien3);
		
		Laptop laptop3 = new Laptop();
		laptop3.setLid(3);
		laptop3.setPrice("344");
		laptop3.setBrand("Kyzer");
		laptop3.setAlien(alien3);
		
		Laptop laptop4 = new Laptop();
		laptop4.setLid(4);
		laptop4.setPrice("344");
		laptop4.setBrand("tihr");
		laptop4.setAlien(alien2);
		
		Laptop laptop5 = new Laptop();
		laptop5.setLid(5);
		laptop5.setPrice("344");
		laptop5.setBrand("rhgrwonrw");
		laptop5.setAlien(alien1);

		laptops.add(laptop5);
		laptops.add(laptop4);
		laptops.add(laptop3);
		laptops.add(laptop2);
		laptops.add(laptop1);
		laptops.add(laptop);
		
		alien1.setAid(34);
		alien1.setAname("navin");
		alien1.setLaptops(laptops);
		
		alien2.setAid(35);
		alien2.setAname("gs");
		alien2.setLaptops(laptops);
		
		alien3.setAid(223);
		alien3.setAname("nehge");
		alien3.setLaptops(laptops);

		
		
		//creating session object
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionfactory = con.buildSessionFactory(reg);
		System.out.println(sessionfactory);
		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();
//		session.save(alien1);
//		session.save(alien2);
//		session.save(alien3);
//		
//		
//		
//		
//		session.save(laptop);
//		session.save(laptop1);
//		session.save(laptop2);
//		session.save(laptop3);
//		session.save(laptop4);
//		session.save(laptop5);
		
		
		
		Alien a1=(Alien)session.get(Alien.class,34);
		System.out.println(a1.getAid());
		System.out.println(a1.getAname());
		
	
				for(Laptop l:a1.getLaptops()) {System.out.println(l.getBrand());};
	
		
		
		//Lazy loading
	
//		List<Laptop> lapsList=a1.getLaptops();
//		for(Laptop l:lapsList) {
//			System.out.println(l.getBrand());
//		}

		tx.commit();
	
		
		session.close();
	}
}
