package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse()
    {
        List<Course> courses =courseRepository.findAll();
        System.out.println("courses "+courses);
    }

    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lasName("Singh")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
    @Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeRecords =
               PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                                .getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();
        System.out.println("totalPages = "+totalPages);
        System.out.println("totalElements = "+totalElements);

        System.out.println("courses = "+courses);
    }

    @Test
    public void findAllSorting()
    {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditdesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()

                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses =
                 courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
    System.out.println("course = "+courses);
    }

    @Test
    public void printfinByTitleContaining()
    {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();
        System.out.println("courses = "+courses);
    }
    @Test
    public void saveWithStudentAndTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("kite")
                .lasName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("abhik")
                .lastName("sin")
                .emailId("ab@Gmail.com")
                .build();

        Course course = Course.builder()
                .title("Es")
                .credit(15)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}