package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

public class StudentDao
 {
 
	public void saveStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			  transaction = session.beginTransaction();
			  session.save(student);
			  transaction.commit();
			
		}catch(Exception e)
		{
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.update(student);
			transaction.commit();
		}catch(Exception e)
		   {
			  if(transaction !=null)
			  {
			       transaction.rollback();
		       }
			  e.printStackTrace();
	       }
	}
	public void deleteStudent(int id)
	{
		Transaction transaction=null;
		Student student=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			 student=session.get(Student.class,id);
			
			if(student !=null)
			{
				session.delete(student);
				System.out.println("Data Deleted...");
			}
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Student getStudent(int id)
	{
		Transaction transaction =null;
		Student student=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			student=session.get(Student.class,id);
			transaction.commit();
			
		}catch(Exception e)
		{
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
		
	}
 }
