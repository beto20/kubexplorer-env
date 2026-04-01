package com.java1.demo;


public interface ProgramService {
    Iterable<ProgramEntity> getPrograms();

    void saveProgram(CourseInfoResponseDto.Program dto);
}
