package com.java_0.demo.rest;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "TeacherFeign", url = "${student.url}")
public interface TeacherFeign {



}
