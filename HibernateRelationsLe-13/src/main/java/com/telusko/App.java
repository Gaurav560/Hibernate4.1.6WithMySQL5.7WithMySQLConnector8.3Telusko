package com.telusko;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class App 
{
	
    public static void main( String[] args )
    {
    	
    	
    	List<Laptop> laptopList=new ArrayList<>();
    	List<Student> studentList=new ArrayList<>();
    	
    	
    	
    	Student student1=new Student();
    	student1.setRollno(6);
    	student1.setMarks(50);
    	student1.setName("Navin");
    	student1.setLaptopList(laptopList);
    	
    	
    	
    	
    	Student student2=new Student();
    	student2.setRollno(5);
    	student2.setMarks(70);
    	student2.setName("gaurav");
    	student2.setLaptopList(laptopList);
    	
    	
    	
    studentList.add(student2);
    studentList.add(student1);
    	
    
    
    	Laptop  laptop1=new Laptop();
    	laptop1.setLid(109);
    	laptop1.setLname("Dell");
    	laptop1.setStudentList(studentList);
    	
    	
    	
    	Laptop  laptop2=new Laptop();
    	laptop2.setLid(110);
    	laptop2.setLname("Lenovo");
    	laptop2.setStudentList(studentList);
    	
    	
    	
    	laptopList.add(laptop1);
    	laptopList.add(laptop2);
    	
    	
    	
    	
    	
    	
    	//creating configuration class object
        org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    
        
        
        
        //works without it also without giving deprecation error
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
       
        
        
        //building session factory which will produce session
        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        
        
        
        
        System.out.println(sessionFactory);
       
        
        
        
       //getting session object so that we can perform operations on our object such as save persist etc
        Session session = sessionFactory.openSession();

        
        
        
        //Beginning of transaction
       Transaction tx = session.beginTransaction();      
       
      
       
       //save has been deprecated as it creates duplicates ,instead persist has been upgraded
     //u cannot persist outside of transaction begin and commit
          
          session.persist(laptop1);
          session.persist(laptop2);
          session.persist(student1);
          session.persist(student2);
          
        tx.commit();

        
        
       session.close(); // Close the session
 }
    }

