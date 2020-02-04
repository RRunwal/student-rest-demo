package com.galvanize;

import com.galvanize.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student student;

    @BeforeEach
    public void setup() throws Exception {
        student = new Student();
        student.setStudentName("Rachana");
        student.setStudentId(1);
        student.setStudentEmail("rrunwal@aol.com");
        student.setCourseStartDate(LocalDate.of(2020, 02, 01));
        student.setCourseEndDate(LocalDate.of(2020, 05, 15));
        student.setCourseName("Java");
        student.setScore(67);
    }

    @Test
    public void gtCourseDaysCheck() {
        int courseDaysRet = student.getCourseDays();
        assertEquals(104, courseDaysRet );
    }


}
