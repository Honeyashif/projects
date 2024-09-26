package com.jsp.spring_mvc.studentdb.service;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;


	public ModelAndView addStudent(Student student) {
		//Adding to Databse / BackEnd Process
		studentRepository.addStudent(student);

		//Return back to UI Page
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index.jsp");

		return mav;
	}

	public ModelAndView findAllStudents(){
		List<Student> students= studentRepository.findAllStudents();

		ModelAndView mav=new ModelAndView();
		mav.setViewName("Display.jsp");
		mav.addObject("students",students);

		return mav;

	}

	public ModelAndView updateStudent(int studentId) {
		Student student=studentRepository.findStudentById(studentId);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("Update.jsp");
		mav.addObject("student", student);

		return mav;
	}

	public ModelAndView saveUpdateStudent(Student updatedStudent) {
		studentRepository.updateStudent(updatedStudent);

		return findAllStudents();
	}

	public ModelAndView deleteStudent(int studentId) {
		Student student=studentRepository.findStudentById(studentId);
		return deleteFindedStudent(student);
	}

	public ModelAndView deleteFindedStudent(Student student) {
		studentRepository.deleteStudent(student);
		return findAllStudents();
	}

}
