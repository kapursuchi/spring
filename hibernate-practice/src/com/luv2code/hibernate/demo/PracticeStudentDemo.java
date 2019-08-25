package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class PracticeStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int empId = 1;
//			
//			  //create a student object
//			  System.out.println("Creating new employee object..."); Employee tempEmp1 =
//			  new Employee("Paul", "Wall", "JavaCoders"); Employee tempEmp2 = new
//			  Employee("Dave", "Black", "Google"); Employee tempEmp3 = new
//			  Employee("Sarah", "Davidson", "Amazon");
//			  
			  //start a transaction
			session.beginTransaction();
//			  
//			  //save the employee object System.out.println("Saving the employee...");
//			  session.save(tempEmp1); session.save(tempEmp2); session.save(tempEmp3);
//			 
//			
//			//retrieve object by primary key
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
//			
			//Employee myEmp = session.get(Employee.class, tempEmp1.getId());
			
			//System.out.println("Get complete: " + myEmp);
			
			//query employees: company = 'Amazon'
			theEmployees = session.createQuery("from Employee e where e.company='Amazon'").getResultList();
			
			displayEmp(theEmployees);
			
			//delete object by primary key
			session.createQuery("delete from Employee where id=3").executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}

	}
	
	private static void displayEmp(List<Employee> theEmployees) {
		for (Employee tempEmp: theEmployees) {
			System.out.println(tempEmp);
		}
	}

}
