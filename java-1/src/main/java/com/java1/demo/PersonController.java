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

    public PersonController(CourseFeign feign) {
        this.feign = feign;
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

    @GetMapping("/public/test")
    public String test() {
        return "prueba";
    }
}
