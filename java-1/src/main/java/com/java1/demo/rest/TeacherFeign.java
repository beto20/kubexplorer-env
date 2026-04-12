package com.java1.demo.rest;


import com.java1.demo.model.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "TeacherFeign", url = "${teacher.url}")
public interface TeacherFeign {

    @GetMapping("/api/teacher")
    Teacher getTeacher();
}
