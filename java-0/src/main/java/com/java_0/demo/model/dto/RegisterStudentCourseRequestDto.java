package com.java_0.demo.model.dto;

import java.io.Serializable;
import java.util.List;

public class RegisterStudentCourseRequestDto implements Serializable {

    private String codStudent;
    private List<String> codCourses;
    private String season;

    public RegisterStudentCourseRequestDto() {
    }

    public String getCodStudent() {
        return codStudent;
    }

    public void setCodStudent(String codStudent) {
        this.codStudent = codStudent;
    }

    public List<String> getCodCourses() {
        return codCourses;
    }

    public void setCodCourses(List<String> codCourses) {
        this.codCourses = codCourses;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
