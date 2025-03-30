package com.java1.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return Arrays.asList(new Course("Matematica", "Curso de matematica I", 3));
    }

    @GetMapping("/test")
    public String test() {
        return "prueba";
    }
}
