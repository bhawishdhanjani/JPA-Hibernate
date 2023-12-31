package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
	void save(Student student);
	Student getStudent(int id); 
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	void update(Student student);
	void delete(int id);
	int deleteAll();

}
