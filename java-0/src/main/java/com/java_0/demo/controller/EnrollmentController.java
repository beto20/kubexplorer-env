package com.java_0.demo.controller;


import com.java_0.demo.model.dto.RegisterStudentCourseRequestDto;
import com.java_0.demo.service.EnrollmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/enroll")
public class EnrollmentController {

    private EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping()
    @Tag(name = "endpoint de matricula", description = "endpoint para matricula de estudiantes de inicio de ciclo")
    private boolean enrollmentStudent(@RequestBody RegisterStudentCourseRequestDto dto) {
        return service.registerSeason(dto);
    }
}
