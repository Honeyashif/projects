package com.jsp.spring_mvc.studentdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@RequestMapping(value = "/add-Student",method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {
		return  studentService.addStudent(student);
	}
	
	@RequestMapping(value = "/display-student",method = RequestMethod.GET)
	public ModelAndView findAllStudents(){
		return studentService.findAllStudents();
	}
	
	
	@RequestMapping(value = "/update-student",method = RequestMethod.GET)
	public ModelAndView updateStudent(int studentId) {
		return studentService.updateStudent(studentId);
	}
	@RequestMapping(value = "/save-updated-student",method = RequestMethod.POST)
	public ModelAndView saveUpdatedStudent(Student updatedStudent) {
		return studentService.saveUpdateStudent(updatedStudent);
		
	}
	
	@RequestMapping(value = "/delete-student",method = RequestMethod.GET)
	public ModelAndView deleteStudent(int studentId) {
		return studentService.deleteStudent(studentId);
	}
	
	@RequestMapping(value = "/delete-finded-student",method = RequestMethod.GET)
	public ModelAndView deleteFindedStudent(Student student) {
		System.out.println(student+"From Contoller");
		return studentService.deleteFindedStudent(student);
	}
	
}
