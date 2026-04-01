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
        return Arrays.asList(
                new Course(12345, "Aplicaciones en la nube", "Curso para desarrollar " +
                "aplicaciones en la nube", 3, "Virtual"),
                new Course(22345, "Desarrollo android", "Curso para desarrollar " +
                        "aplicaciones en Android", 5, "Lima centro")
        );
    }

    @GetMapping("/test")
    public String test() {
        return "prueba";
    }
}
