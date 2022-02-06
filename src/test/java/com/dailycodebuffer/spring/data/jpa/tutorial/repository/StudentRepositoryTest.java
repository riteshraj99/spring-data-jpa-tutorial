package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("riteshraj@gmail.com")
                .firstName("Ritesh")
                .lastName("Kumar")
//                .guardianName("Ayodhya")
//                .guardianEmail("ay@gmail.com")
//                .guardianMobile("99999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("09864")
                .build();
        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = "+ studentList);
    }

    @Test
    public void printStudentByFirstName()
    {
        List<Student> student = studentRepository.findByFirstName("shivam");
        System.out.println("students = "+student);
    }
    @Test
    public void printStudentByFirstNameContaining()
    {
        List<Student> student = studentRepository.findByFirstNameContaining("r");
        System.out.println("students = "+student);
    }
    @Test
    public void printStudentByLastNameContaining()
    {
        List<Student> student = studentRepository.findByLastNameContaining("kum");
        System.out.println("students = "+student);
    }
    @Test
    public void printStudentBasedOnGuardianName()
    {
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println("Students "+students);
    }

    @Test
    public void printgetStudentByEmailAddress()
    {
        Student student = studentRepository.getStudentByEmaiAddress(
                "riteshraj@gmail.com"
        );
        System.out.println("studnet = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress()
    {
     String firstName = studentRepository.getStudentFirstNameByEmaiAddress(
             "shivam@gmail.com");
     System.out.println("Student "+firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative()
    {
        Student student = studentRepository.getStudentByEmailAddressNative(
                "riteshraj@gmail.com"
        );
        System.out.println("Student "+student);

    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam()
    {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "riteshraj@gmail.com"
        );
        System.out.println("Student "+student);

    }

    @Test
    public void updateStudentNameByEmailIdTest()
    {
        studentRepository.updateStudentNameByEmailId(
                "Shiva",
                "shivam@gmail.com"
        );

    }
}