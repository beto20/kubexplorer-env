package com.java1.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CourseFeign", url = "${course.url}")
public interface CourseFeign {

    @GetMapping("/api/courses")
    List<Course> getCourses();
}
