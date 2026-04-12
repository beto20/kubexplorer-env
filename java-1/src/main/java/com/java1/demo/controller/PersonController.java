package com.java1.demo.controller;


import com.java1.demo.model.dto.CourseInfoResponseDto;
import com.java1.demo.model.Person;
import com.java1.demo.model.PersonFull;
import com.java1.demo.rest.CourseFeign;
import com.java1.demo.rest.TeacherFeign;
import com.java1.demo.service.ProgramService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final CourseFeign feign;
    private final TeacherFeign teacherFeign;
    private final ProgramService service;

    public PersonController(CourseFeign feign, TeacherFeign teacherFeign, ProgramService service) {
        this.feign = feign;
        this.teacherFeign = teacherFeign;
        this.service = service;
    }

    @GetMapping("/public")
    public List<Person> getPerson() {
        return Arrays.asList(new Person("Pedro", "Marquez", "10/10/2000"));
    }

    @GetMapping("/private")
    public List<Person> getPersonPrivate() {
        return Arrays.asList(new Person("Private", "Private", "10/10/2000"));
    }

    @GetMapping("/private/full")
    public List<PersonFull> getFullPerson() {
        var course = feign.getCourses();
        return Arrays.asList(new PersonFull("Pedro", "Marquez", "10/10/2000", course.get(0).name(), course.get(0).credit()));
    }

    @GetMapping("/course-information")
    public CourseInfoResponseDto courseInformation() {
        var course = feign.getCourses();
        var teacher = teacherFeign.getTeacher();

        var response = new CourseInfoResponseDto();
        var teacherDto = new CourseInfoResponseDto.Teacher();
        var programDto = new CourseInfoResponseDto.Program();

        teacherDto.setName(teacher.name());
        teacherDto.setLastname(teacher.lastname());
        teacherDto.setAge(teacher.age());
        teacherDto.setEmail(teacher.email());

        response.setId(course.get(0).id());
        response.setName(course.get(0).name());
        response.setDescription(course.get(0).description());
        response.setCredit(course.get(0).credit());
        response.setLocation(course.get(0).location());
        response.setTeacher(teacherDto);

        service.getPrograms().forEach(x -> {
            programDto.setId(x.getId());
            programDto.setName(x.getName());
            programDto.setDescription(x.getDescription());
            programDto.setTime(x.getTime());
            programDto.setCoursesQuantity(x.getCoursesQuantity());
            programDto.setCreditQuantity(x.getCreditQuantity());
        });

        response.setProgram(programDto);

        return response;
    }

    @PostMapping("/program")
    public void createProgram(@RequestBody CourseInfoResponseDto.Program dto) {
        service.saveProgram(dto);
    }


    @GetMapping("/public/test")
    public String test() {
        return "prueba";
    }
}
