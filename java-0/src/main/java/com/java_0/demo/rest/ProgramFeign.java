package com.java_0.demo.rest;


import com.java_0.demo.model.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProgramFeign", url = "${student.url}")
public interface ProgramFeign {



}
