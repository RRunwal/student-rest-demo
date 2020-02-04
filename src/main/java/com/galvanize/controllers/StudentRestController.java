package com.galvanize.controllers;

import com.galvanize.entities.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    @GetMapping
    public Student getStudentInfo(@RequestParam String studentName,
                               @RequestParam int studentId,
                               @RequestParam String studentEmail,
                               @RequestParam @DateTimeFormat(pattern = "M/d/yyyy") LocalDate courseStartDate,
                               @RequestParam @DateTimeFormat(pattern = "M/d/yyyy") LocalDate courseEndDate,
                               @RequestParam String courseName,
                               @RequestParam double score) {
        Student student = new Student(studentName, studentId,
                studentEmail, courseStartDate, courseEndDate,
                courseName, score);
        System.out.println(student);
        return student;
    }

    @PostMapping
    public Student postStudentObject(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

}
