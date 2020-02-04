package com.galvanize.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Student {
    private String studentName;
    private int studentId;
    private String studentEmail;
    @JsonFormat(pattern = "M/d/yyyy")
    private LocalDate courseStartDate;
    @JsonFormat(pattern = "M/d/yyyy")
    private LocalDate courseEndDate;
    private String courseName;
    private double score;

    public Student() {
    }

    public Student(String studentName,
                   int studentId,
                   String studentEmail,
                   LocalDate courseStartDate,
                   LocalDate courseEndDate,
                   String courseName,
                   double score) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseName = courseName;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(LocalDate courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public LocalDate getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(LocalDate courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCourseDays() {
//        Calendar c = Calendar.getInstance();
//        c.setTime(this.courseStartDate);
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH) + 1;
//        int day = c.get(Calendar.DATE);
//        LocalDate ll = LocalDate.of(year, month, day);
//        c.setTime(this.courseEndDate);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        day = c.get(Calendar.DATE);
//        LocalDate now = LocalDate.of(year, month, day);
//        Period diff = Period.between(ll, now);
        return (int) ChronoUnit.DAYS.between(courseStartDate, courseEndDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                ", studentEmail='" + studentEmail + '\'' +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                ", courseName='" + courseName + '\'' +
                ", score=" + score +
                ", courseDays=" + getCourseDays() +
                '}';
    }
}
