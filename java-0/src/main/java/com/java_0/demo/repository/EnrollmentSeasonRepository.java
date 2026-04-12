package com.java_0.demo.repository;

import com.java_0.demo.model.entity.EnrollmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentSeasonRepository extends CrudRepository<EnrollmentEntity, Integer> {
}
