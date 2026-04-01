package com.java1.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final CourseFeign feign;
    private final TeacherFeign teacherFeign;

    public PersonController(CourseFeign feign, TeacherFeign teacherFeign) {
        this.feign = feign;
        this.teacherFeign = teacherFeign;
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

        return response;
    }



    @GetMapping("/public/test")
    public String test() {
        return "prueba";
    }
}
