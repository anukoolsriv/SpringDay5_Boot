package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Student;
import com.lti.service.StudentService;

@RestController
@RequestMapping(path = "students")
public class StudentRestController {

	@Autowired
	private StudentService service;

	// http://localhost:9090/students
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	// JSON/ XML??
	public List<Student> findAllStudents() {
		List<Student> students = service.getAllStudents();

		return students;
	}

	// http://localhost:9090/students/100
	@RequestMapping(path = "{rollNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student findStudentByRollNumber(@PathVariable("rollNumber") int rollNumber) {
		Student student = service.findStudentByRollNumber(rollNumber);
		return student;
	}

	// http://localhost:9090/students
	@RequestMapping(method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);

	}
	//http://localhost:9090/students/
	@RequestMapping(path="{rollno}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudent(@PathVariable("rollno") int rollNumber){
		service.deleteStudent(rollNumber);
	}
	//http://localhost:9090/students
	@RequestMapping(path = "update", method=RequestMethod.POST)
	public void updateStudent(@RequestBody Student student){
		service.updateStudent(student);
	}
}
