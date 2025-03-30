package com.java1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    private final PersonFeign feign;

    public TeacherController(PersonFeign feign) {
        this.feign = feign;
    }
    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        var full = feign.getFull();
        return Arrays.asList(new Teacher("Marco", "Aguirre", "Matematica", "Mañana", full.getFirst()));
    }

}
