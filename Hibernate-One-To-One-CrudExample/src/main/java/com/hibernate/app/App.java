package com.hibernate.app;

import com.hibernate.dao.StudentDao;
import com.hibernate.entity.Student;
import com.hibernate.entity.StudentDetails;

public class App {
               
	public static void main(String args[])
	{
		Student student=new Student("shivam","Varshney","Shivam@gmail.com");
		StudentDetails studentdetails=new StudentDetails("http://www.youtube.com", "Guitar");
		
		studentdetails.setStudent(student);
		student.setStudentdetails(studentdetails);
		
		StudentDao studentDao=new StudentDao();
	
		studentDao.saveStudent(student);
		studentDao.getStudent(1);
		System.out.println("save data..");
		
	}
}
