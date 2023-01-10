package com.example.hostel.model;

import com.example.hostel.entity.Event;
import com.example.hostel.entity.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

public class StudentForm {
    private Integer studentId;

    @NotEmpty(message = "Please input student name.")
    @Size(min = 1, max = 200, message = "Please input between between {min} and {max} characters.")
    private String studentName;

    @NotEmpty(message = "Please input student year.")
    private String studentYear;

    @NotEmpty(message = "Please input student contact number.")
    private String studentContactNo;

    @NotEmpty(message = "Please input student email.")
    private String studentEmail;

    private Collection<Event> events;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudentContactNo() {
        return studentContactNo;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }
}
