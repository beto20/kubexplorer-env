package com.java_0.demo.service;

import com.java_0.demo.model.dto.RegisterStudentCourseRequestDto;

public interface EnrollmentService {

    boolean registerSeason(RegisterStudentCourseRequestDto dto);
}
