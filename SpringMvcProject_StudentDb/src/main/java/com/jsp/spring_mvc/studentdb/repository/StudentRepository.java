package com.jsp.spring_mvc.studentdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jsp.spring_mvc.studentdb.entity.Student;

@Repository
public class StudentRepository {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysql-config");

	public void addStudent(Student student) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();

		em.persist(student);

		et.commit();
		em.close();
	}

	public void updateStudent(Student updatedStudent) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();

		em.merge(updatedStudent);

		et.commit();
		em.close();
	}

	public void deleteStudent(Student findedStudent) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();

		if(em.contains(findedStudent)) 
			em.remove(findedStudent);
		else
			em.remove((em.merge(findedStudent)));

		et.commit();
		em.close();
	}

	public Student findStudentById(int studentId) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();

		Student student=em.find(Student.class, studentId);
		System.out.println(student+"from");

		et.commit();
		em.close();
		return student;
	}

	public List<Student> findAllStudents() {

		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();

		Query query=em.createQuery("FROM Student");
		List<Student> students=query.getResultList();

		et.commit();
		em.close();

		return students;

	}
}
