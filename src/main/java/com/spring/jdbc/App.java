package com.spring.jdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("My pgm started .......");

        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao1 = context.getBean("studentDao",StudentDao.class);
        StudentDao studentDao2 = context.getBean("studentDao1",StudentDao.class);
        Student student1 = new Student(4,"Harsh","Shikarpur");
        
//        studentDao2.createDatabase();
     
//        int res = studentDao1.insert(student2);
//        int res = studentDao1.update(student2);
      
//        int res = studentDao1.delete(23);
//        String query="create table employee(id int primary key,name varchar(100),city varchar(200));";
//        int res =  studentDao1.create(query);
//        System.out.println("number of record inserted : "+res);
        System.out.println(studentDao1.getStudent(1));
        System.out.println(studentDao1.getAllStudent());
        
    }
}
