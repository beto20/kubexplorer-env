package com.java1.demo.service;

import com.java1.demo.model.dto.StudentResponseDto;
import com.java1.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDto getStudent(String codStudent) {
        var entity = studentRepository.findByCodStudent(codStudent);

        var dto = new StudentResponseDto();
        dto.setCodStudent(entity.getCodStudent());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        dto.setEmail(entity.getEmail());
        dto.setBirthday(entity.getBirthday());

        return dto;
    }
}
