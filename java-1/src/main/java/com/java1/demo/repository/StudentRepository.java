package com.java1.demo.repository;

import com.java1.demo.model.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    StudentEntity findByCodStudent(String codStudent);
}
