package com.raj.bootmvcexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.bootmvcexample.form.Student;
import com.raj.bootmvcexample.mapper.StudentMapper;
import com.raj.bootmvcexample.repository.StudentDao;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private StudentMapper mapper;
	
	public List<Student> getAllStudents(){
		System.out.println("getting all students");
		List<Student> list = new ArrayList<>();
		Iterable<com.raj.bootmvcexample.model.Student> itr = studentDao.findAll();
		for (com.raj.bootmvcexample.model.Student student : itr) {
			list.add(mapper.mapStudentBeanToStudentForm(student));
		}
		
		return list;
	}

	public Student getStudentById(Long id) {

		com.raj.bootmvcexample.model.Student studentBean = studentDao.findOne(id);
		return mapper.mapStudentBeanToStudentForm(studentBean);
	}

	public void saveStudent(Student student) {
		System.out.println("Saving student info");
		com.raj.bootmvcexample.model.Student studentBean = mapper.mapStudentFormToStudentBean(student);
		studentDao.save(studentBean);
	}

}
