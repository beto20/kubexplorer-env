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
                new Course(12345, "C00001","Aplicaciones en la nube", "Curso para desarrollar " +
                "aplicaciones en la nube", 3, "Virtual"),
                new Course(22345, "C00002","Desarrollo android", "Curso para desarrollar " +
                        "aplicaciones en Android", 5, "Lima centro"),
                new Course(99204, "C00003","Desarrollo servicio web 2", "Curso para desarrollar " +
                        "aplicaciones en Android", 5, "San Juan de Lurigancho"),
                new Course(77528, "C00004","Curso Integrador 2", "Curso para desarrollar " +
                        "aplicaciones en Android", 5, "Lima centro"),
                new Course(12981, "C00005","Redaccion", "Curso para desarrollar " +
                        "aplicaciones en Android", 5, "Ate")
        );
    }

    @GetMapping("/test")
    public String test() {
        return "prueba";
    }
}
