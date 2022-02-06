package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course courseDba = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("java")
                .credit(5)
                .build();
        List<Course> list = new ArrayList<Course>();
        list.add(courseDba);
        list.add(courseJava);


        Teacher teacher = Teacher.builder()
                .firstName("Shamgunatham")
                .lasName("Nathan")
//                .courses(list)
                .build();

        teacherRepository.save(teacher);
    }
}