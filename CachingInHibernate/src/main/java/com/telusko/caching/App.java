package com.telusko.caching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		Alien a = null;
		Alien a1 = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionfactory = con.buildSessionFactory(reg);
		System.out.println(sessionfactory);

//session 1
		Session session1 = sessionfactory.openSession();

		Transaction tx = session1.beginTransaction();
	//	a = (Alien) session1.get(Alien.class, 1);
		
		Query q1=session1.createQuery("from Alien where aid=1");
		q1.setCacheable(true);
		a=(Alien)q1.uniqueResult();
		
		System.out.println(a.getColor());

		// 1st level caching happens in same session .
		// only one query generated for similar request(internally provided in
		// hibernate)
//		Alien a1 = (Alien) session1.get(Alien.class, 1);
//		System.out.println(a1.getColor());
	tx.commit();
session1.close();
//		2nd level caching done externally .
		// used by different session as a common storage point .famous is ehcache

//		session2
      Session session2=sessionfactory.openSession();
		
		Transaction tx1=session2.beginTransaction();
	     //  a=(Alien)session2.get(Alien.class,1);
	       Query q2=session2.createQuery("from Alien where aid=1");
	       q2.setCacheable(true);
	       a1=(Alien)q2.uniqueResult();
	     System.out.println(a1.getColor());
		
		  tx1.commit();
		   session2.close();

	}
}
