package com.java1.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class CourseInfoResponseDto {

    public CourseInfoResponseDto(int id, String name, String description, int credit, String location, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credit = credit;
        this.location = location;
        this.teacher = teacher;
    }

    public CourseInfoResponseDto() {
    }

    private int id;
    private String name;
    private String description;
    private int credit;
    private String location;
     Teacher teacher;

    public static class Teacher {
        private String name;
        private String lastname;
        private int age;
        private String email;

        public Teacher() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
