package com.java1.demo.service;


import com.java1.demo.model.dto.CourseInfoResponseDto;
import com.java1.demo.model.entity.ProgramEntity;

public interface ProgramService {
    Iterable<ProgramEntity> getPrograms();

    void saveProgram(CourseInfoResponseDto.Program dto);
}
