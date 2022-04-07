package com.hibernate.util;

import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDao;
import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;

public class ManApp {
    public static void main(String[] args) {

        InstructorDao instructorDao = new InstructorDao();
        CourseDao courseDao = new CourseDao();

        Instructor instructor = new Instructor( "varun ", "Varshney", "ramesh@javaguides.com");
        instructorDao.saveInstructor(instructor);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        tempCourse1.setInstructor(instructor);
        courseDao.saveCourse(tempCourse1);

        Course tempCourse2 = new Course("The Pinball Masterclass");
        tempCourse2.setInstructor(instructor);
        courseDao.saveCourse(tempCourse2);
    }
}