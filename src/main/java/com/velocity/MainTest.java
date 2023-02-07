package com.velocity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee emp1=new Employee();
		emp1.setEmp_name("shweta");
		Employee emp2=new Employee();
		emp1.setEmp_name("Swaraj");
		
		Project p1=new Project();
		p1.setName("Microservices");
		Project p2=new Project();
		p2.setName("Angular");
		
		List<Employee> emp=new ArrayList();
		emp.add(emp1);
		emp.add(emp2);
		
		List<Project> project =new ArrayList();
		project.add(p1);
		project.add(p2);
		
		p1.setEmp(emp);
		emp1.setProject(project);
		
		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);
		session.getTransaction().commit();
		session.close();
		}

}
