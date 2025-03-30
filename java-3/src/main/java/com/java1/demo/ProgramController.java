package com.java1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProgramController {
    private final TeacherFeign feign;

    public ProgramController(TeacherFeign feign) {
        this.feign = feign;
    }
    @GetMapping("/program")
    public List<Program> getProgram() {
        var teacher = feign.getTeacher();
        return Arrays.asList(new Program(
                teacher.get(0).name(),
                teacher.get(0).lastname(),
                teacher.get(0).course(),
                teacher.get(0).schedule(),
                teacher.get(0).personFull().name(),
                teacher.get(0).personFull().Lastname(),
                teacher.get(0).personFull().credit()
        ));
    }

}
