package com.raj.bootmvcexample.mapper;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.raj.bootmvcexample.form.Student.Gender;
import com.raj.bootmvcexample.model.Student;

@Component
public class StudentMapper {
	
	public Student mapStudentFormToStudentBean(com.raj.bootmvcexample.form.Student studentForm){
		Student student = new Student();
		student.setName(studentForm.getName());
		student.setAge(studentForm.getAge());
		student.setEmail(studentForm.getEmail());
		student.setBirthday(new Date(studentForm.getBirthday().getTime()));
		student.setGender(studentForm.getGender().name());
		student.setPhone(studentForm.getPhone());
		return student;
	}
	
	public com.raj.bootmvcexample.form.Student mapStudentBeanToStudentForm(Student studentBean){
		com.raj.bootmvcexample.form.Student student = new com.raj.bootmvcexample.form.Student();
		student.setName(studentBean.getName());
		student.setAge(studentBean.getAge());
		student.setEmail(studentBean.getEmail());
		student.setBirthday(new Date(studentBean.getBirthday().getTime()));
		student.setGender(Gender.valueOf(studentBean.getGender()));
		student.setPhone(studentBean.getPhone());
		return student;
	}

}
