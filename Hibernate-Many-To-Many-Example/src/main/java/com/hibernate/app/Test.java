package com.hibernate.app;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;
import com.hibernate.util.HibernateUtil;

public class Test {

	public static void main(String args[]) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee employee=new Employee();
		employee.setFirstName("shivam");
		employee.setLastName("Varshney");
		
		Project project=new Project();
		project.setTitle("Employee Management System");
		
		Project project1=new Project();
		project1.setTitle("Content Management System");
		
		employee.getProjects().add(project);
		employee.getProjects().add(project1);
		
		project.getEmployees().add(employee);
		project1.getEmployees().add(employee);
		
		session.save(employee);
		session.save(project1);
		session.save(project);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		
	}
}
