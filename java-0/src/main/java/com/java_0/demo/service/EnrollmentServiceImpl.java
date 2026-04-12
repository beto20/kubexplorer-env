package com.java_0.demo.service;

import com.java_0.demo.model.dto.CourseDto;
import com.java_0.demo.model.dto.RegisterStudentCourseRequestDto;
import com.java_0.demo.model.dto.StudentDto;
import com.java_0.demo.model.entity.CourseEntity;
import com.java_0.demo.model.entity.EnrollmentEntity;
import com.java_0.demo.model.entity.StudentEntity;
import com.java_0.demo.repository.EnrollmentSeasonRepository;
import com.java_0.demo.rest.CourseFeign;
import com.java_0.demo.rest.ProgramFeign;
import com.java_0.demo.rest.StudentFeign;
import com.java_0.demo.rest.TeacherFeign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private StudentFeign studentFeign;
    private CourseFeign courseFeign;
    private TeacherFeign teacherFeign;
    private ProgramFeign programFeign;
    private EnrollmentSeasonRepository repository;

    public EnrollmentServiceImpl(StudentFeign studentFeign, CourseFeign courseFeign, TeacherFeign teacherFeign, ProgramFeign programFeign, EnrollmentSeasonRepository repository) {
        this.studentFeign = studentFeign;
        this.courseFeign = courseFeign;
        this.teacherFeign = teacherFeign;
        this.programFeign = programFeign;
        this.repository = repository;
    }

    @Override
    public boolean registerSeason(RegisterStudentCourseRequestDto dto) {
        var studentEntity = new StudentEntity();
        var coursesEntity = new ArrayList<CourseEntity>();
        var enrollmentEntity = new EnrollmentEntity();

        var student = studentFeign.getStudent(dto.getCodStudent());
        var courses = courseFeign.getCourses();

        buildCourseEntity(courses, dto.getCodCourses(), coursesEntity);
        buildStudentEntity(student, studentEntity);

        enrollmentEntity.setStudent(studentEntity);
        enrollmentEntity.setCourses(coursesEntity);
        enrollmentEntity.setSeason(dto.getSeason());

        repository.save(enrollmentEntity);

//        if (!student.getCodStudent().isEmpty()) {
//            System.out.println(student.getCodStudent());
//            return true;
//        }

        return false;
    }

    private void buildCourseEntity(List<CourseDto> courses, List<String> codCourses, List<CourseEntity> entities) {
        for (int i = 0; i < codCourses.size(); i++) {
            if (codCourses.get(i).equals(courses.get(i).codCourse())) {
                var courseEntity = new CourseEntity();
                courseEntity.setCodCourse(codCourses.get(i));
                courseEntity.setName(courses.get(i).name());
                courseEntity.setLocation(courses.get(i).location());
                courseEntity.setCredit(courses.get(i).credit());

                entities.add(courseEntity);
            }
        }
    }

    private void buildStudentEntity(StudentDto dto, StudentEntity entity) {
        entity.setCodStudent(dto.getCodStudent());
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setEmail(dto.getEmail());
    }

}
