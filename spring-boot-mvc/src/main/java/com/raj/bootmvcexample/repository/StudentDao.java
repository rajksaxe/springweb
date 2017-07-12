package com.raj.bootmvcexample.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raj.bootmvcexample.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student,Long>{

}
