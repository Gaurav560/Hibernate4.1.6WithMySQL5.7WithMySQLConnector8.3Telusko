package com.telusko.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		// creating session object
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionfactory = con.buildSessionFactory(reg);

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();
		
		
		//sql query to find certain columns in hibernate(Native Queries)
		SQLQuery query = session.createSQLQuery("select marks, sname from Student where marks > 65");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		List<Object> students = query.list();

		for (Object o : students) {
		    Map<String, Object> m = (Map<String, Object>) o;
		    System.out.println(m.get("marks") + " " + m.get("sname"));
		}

		
		
		
			
	/*
		 * //sql query in hibernate (Native Queries)
		 * 
		 * SQLQuery query=session.createSQLQuery("select * from Student where marks>65");
		 * query.addEntity(Student.class); List<Student> students=query.list();
		 * for(Student s:students) { System.out.println(s); }
		 */
		 

			/*positional parameters 
			 * 
			 * int b=65;
			 * Query query=session.createQuery("select sum(marks) from Student s where s.marks>:b"
			 * ); query.setParameter("b", b); Long sumOfMarks=(Long)query.uniqueResult();
			 * System.out.println(sumOfMarks);
			 */
		 
		 
		 
			/*hql query to use alias
			 * 
			 * 
			 * Query query=session.
			 * createQuery("select rollNo,marks,sname from Student s where s.marks>65");
			 * List<Object[]> students=(List<Object[]>)query.list(); for(Object[]
			 * student:students) {
			 * System.out.println(student[0]+" "+student[1]+" "+student[2]); }
			 */
		 
		/*
		 * //hql query to return an array of objects 
		 * 
		 * 
		 *Query query=session.createQuery("select rollNo,marks,sname from Student");
		 * List<Object[]> students=(List<Object[]>)query.list(); for(Object[]
		 * student:students) {
		 * System.out.println(student[0]+" "+student[1]+" "+student[2]); }
		 */
		
		
		
		/*//these types of hql query gives you array of object 
		 * 
		 * Query query=session.
		 * createQuery("select rollNo,marks,sname from Student where rollNo=7");
		 * 
		 * Object[] student=(Object[])query.uniqueResult(); for(Object o:student) {
		 * System.out.println(o); }
		 */
	
	
	
	/*//hql query to get a particular object 
	 * 
	 * Student student=(Student) query.uniqueResult();
	 *  System.out.println(student);
	 */
	
	/*hql query to get a list of students
	 *
	 * List<Student> students= (List<Student>) query.list(); for (Student student :
	 * students) { System.out.println(student); }
	 */

	
		tx.commit();

		session.close();
	}
}
