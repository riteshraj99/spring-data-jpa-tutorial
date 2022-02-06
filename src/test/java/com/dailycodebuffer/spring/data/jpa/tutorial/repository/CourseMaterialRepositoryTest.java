package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial()
    {
        Course course = Course.builder()
                .title(".net")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.daily.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials()
    {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Matrials "+courseMaterials);

    }

}