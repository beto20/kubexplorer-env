package com.java1.demo.model.dto;


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
    Program program;

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

    public static class Program {
        private Integer id;
        private String name;
        private String description;
        private int time;
        private int creditQuantity;
        private int coursesQuantity;

        public Program() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getCreditQuantity() {
            return creditQuantity;
        }

        public void setCreditQuantity(int creditQuantity) {
            this.creditQuantity = creditQuantity;
        }

        public int getCoursesQuantity() {
            return coursesQuantity;
        }

        public void setCoursesQuantity(int coursesQuantity) {
            this.coursesQuantity = coursesQuantity;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
