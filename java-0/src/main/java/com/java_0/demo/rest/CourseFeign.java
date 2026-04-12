package com.java_0.demo.rest;


import com.java_0.demo.model.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CourseFeign", url = "${course.url}")
public interface CourseFeign {

    @GetMapping("/api/courses")
    List<CourseDto> getCourses();

}
