package com.telusko.HibernateJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Alien a2=new Alien();
    	a2.setAid(4);
    	a2.setAname("Gaurav");
    	a2.setColor("rex");
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
    	EntityManager em=emf.createEntityManager();
    	em.getTransaction().begin();
       em.persist(a2);
        em.getTransaction().commit();
        
    }
}
