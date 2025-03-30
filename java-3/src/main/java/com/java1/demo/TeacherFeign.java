package com.java1.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "TeacherFeign", url = "${teacher.url}")
public interface TeacherFeign {

    @GetMapping("/api/full")
    List<Teacher> getTeacher();
}
