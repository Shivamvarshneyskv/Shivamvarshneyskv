package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.StudentDetails;
import com.hibernate.util.HibernateUtil;

public class StudentDetailsDao {

	  public void saveStudentDetails(StudentDetails studentDetails)
	  {
		  Transaction transaction=null;
		  try(Session session=HibernateUtil.getSessionFactory().openSession())
		   {
			 transaction=session.beginTransaction();
			 session.save(studentDetails);
			 transaction.commit();	 
		   }
		  catch(Exception e)
		    {
			  if(transaction !=null)
			  {
			    transaction.rollback();	
			  }
			 e.printStackTrace();
		  }
		  
	  }
	  
	  public void updateStudentDetails(StudentDetails studentDetails)
	  {
		Transaction transaction =null;
		try(Session session =HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.update(studentDetails);
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
	  
	  public StudentDetails getStudentDetails(int id)
	  {
		  Transaction transaction =null;
		  StudentDetails studentDetails=null;
		  
			try(Session session =HibernateUtil.getSessionFactory().openSession())
			{
				transaction=session.beginTransaction();
				studentDetails=session.get(StudentDetails.class,id);
				transaction.commit();
				
			}catch(Exception e)
			{
				if(transaction !=null)
				{
				 transaction.rollback();	
				}
				e.printStackTrace();
			}
		  return studentDetails;
			  
	  }
	
	
}
