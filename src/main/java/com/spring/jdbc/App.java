package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//XML BASED 
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

//ANNOTATION BASED/JAVA BASED
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);

// INSERT
		Student student = new Student();
		student.setSid(9);
		student.setScity("nagar");
		student.setSname("gaurav");
		int result = studentDaoImpl.insert(student);
		System.out.println("student added " + result);

// UPDATE
//		Student s = new Student();
//		s.setScity("pune");
//		s.setSid(12);
//		s.setSname("pankaj");
//		int result = studentDaoImpl.change(s);
//		System.out.println("student update " + result);

// DELETE
//		Student s = new Student();
//		int r = studentDaoImpl.deleteStudent(1);
//		System.out.println("data deleted ");

// SELECT
//		Student student = studentDaoImpl.getStudent(6);
//		System.out.println(student);

//SELECT MULTIPLE OBJECTS
		List<Student> students = studentDaoImpl.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}

	}
}

//insert query
/*
 * String query = "insert into student(sid,sname,scity) values(?,?,?)";
 * 
 * System.out.println("Enter id Name and city of student ! "); int id =
 * sc.nextInt(); // Clear the newline character left in the buffer
 * sc.nextLine(); String name = sc.nextLine(); String city = sc.nextLine(); int
 * result = template.update(query, id, name, city);
 * System.out.println(" Data Inserted...! " + result);
 */
