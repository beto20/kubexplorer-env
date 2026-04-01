package com.java1.demo;


import jakarta.persistence.*;

@Entity
@Table(name = "carrera_profesional")
public class ProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int time;
    private int creditQuantity;
    private int coursesQuantity;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTime() {
        return time;
    }

    public int getCreditQuantity() {
        return creditQuantity;
    }

    public int getCoursesQuantity() {
        return coursesQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCreditQuantity(int creditQuantity) {
        this.creditQuantity = creditQuantity;
    }

    public void setCoursesQuantity(int coursesQuantity) {
        this.coursesQuantity = coursesQuantity;
    }
}
