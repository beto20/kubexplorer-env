package com.java1.demo.controller;


import com.java1.demo.model.dto.StudentResponseDto;
import com.java1.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{codStudent}")
    private StudentResponseDto getStudent(@PathVariable String codStudent) {
        return service.getStudent(codStudent);
    }
}
