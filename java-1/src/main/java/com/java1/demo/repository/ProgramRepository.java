package com.java1.demo.repository;

import com.java1.demo.model.entity.ProgramEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<ProgramEntity, Integer> {
}
