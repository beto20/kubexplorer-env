package com.java1.demo;

import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

    public final ProgramRepository repository;

    public ProgramServiceImpl(ProgramRepository repository) {
        this.repository = repository;
    }
    @Override
    public Iterable<ProgramEntity> getPrograms() {
        return repository.findAll();
    }

    @Override
    public void saveProgram(CourseInfoResponseDto.Program dto) {
        var entity = new ProgramEntity();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTime(dto.getTime());
        entity.setCoursesQuantity(dto.getCoursesQuantity());
        entity.setCreditQuantity(dto.getCreditQuantity());

        repository.save(entity);
    }
}
