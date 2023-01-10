package com.example.hostel.service;

import com.example.hostel.model.StudentForm;
import com.example.hostel.model.StudentModel;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    List<StudentModel> getAllStudents();
    StudentModel getStudent(Integer studentId);
    void createNewStudent(StudentForm student) throws ParseException;
    void deleteStudent(Integer studentId);
    void updateStudent(StudentForm studentForm) throws ParseException;
}
