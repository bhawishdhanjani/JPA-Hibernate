package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);		
	}

	@Override
	public Student getStudent(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query=  entityManager.createQuery("FROM Student",Student.class);
		return query.getResultList();
		
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		query.setParameter("theData", lastName);
		return query.getResultList();
	}
	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		Student student = entityManager.find( Student.class,id);
		entityManager.remove(student);
		
		
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numOfRowsDeleted;
	}
	
	
	

}
