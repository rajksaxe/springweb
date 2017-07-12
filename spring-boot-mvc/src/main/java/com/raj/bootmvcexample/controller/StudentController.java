package com.raj.bootmvcexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.bootmvcexample.form.Student;
import com.raj.bootmvcexample.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	private Map<String, Student> students = null;

	public StudentController() {
		students = new HashMap<String, Student>();
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentForm(Model model) {
		System.out.println("Returning student.jsp page");
		model.addAttribute("student", new Student());
		return "student";
	}
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable Long id) {
		System.out.println("Returning student.jsp page");
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudent(Model model) {
		System.out.println("Returning student.jsp page");
		
		return studentService.getAllStudents();
	}
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String saveStudentsInfo(@Valid Student student, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning std.jsp page");
			return "student";
		}
		System.out.print("Returning stdsave.jsp page");
		studentService.saveStudent(student);
		model.addAttribute("student", student);
		students.put(student.getEmail(), student);
		return "result";
	}

}


