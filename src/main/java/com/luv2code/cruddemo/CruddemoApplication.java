package com.luv2code.cruddemo;

import java.util.List;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}



	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all the students");
		int nonumOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("No of rows deleted: "+nonumOfRowsDeleted);
		
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 2; 
		System.out.println("Deleting record with id "+id);
		studentDAO.delete(id);
		System.out.println("Deleted.");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int theID = 1;
		System.out.println("Fetching Data id " + theID);
		Student student =  studentDAO.getStudent(theID);
		System.out.println(student);
		student.setFirstName("Perkash");
		System.out.println("Updatig the Data..");
		studentDAO.update(student);
		System.out.println("After Updateeee...");
		System.out.println(student);
		
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Chand");
		for(var student : students) {
			System.out.println(student);
		}
	
		
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(var student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		Student student = new Student("Lal", "Chand", "lalchand@gmail.com");
		System.out.println("Saving the students ...");
		studentDAO.save(student);
		int theId = student.getId();
		System.out.println("Saved Student with ID: " + theId);
		System.out.println("Retrieving Student with ID: "+theId );
		Student student2 = studentDAO.getStudent(theId);
		System.out.println(student2);
	
		
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		Student student1 = new Student("Manesh", "Kumar", "manesh@gmail.com");
		Student student2 = new Student("Mukesh", "Kumar", "mukesh@gmail.com");
		Student student3 = new Student("Vinay", "Kumar", "vinay@gmail.com");	
		
		System.out.println("Saving the students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Object are Saved");
		
	
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		Student student = new Student("Bhavesh", "Kumar", "bhawishdhanjanii@gmail.com");
		System.out.println("Saving the students ...");
		studentDAO.save(student);
		System.out.println("Saved Student Id is " + student.getId());
		
		
	
				
		
	}

}
