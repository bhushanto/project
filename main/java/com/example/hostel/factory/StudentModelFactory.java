package com.example.hostel.factory;

import com.example.hostel.entity.Student;
import com.example.hostel.model.StudentModel;
import org.thymeleaf.util.StringUtils;

public class StudentModelFactory {

    public static StudentModel toStudentModel(Student student) {
        StudentModel model = new StudentModel();
        model.setStudentId(student.getStudentId());
        model.setStudentName(student.getStudentName());
        model.setStudentYear(student.getStudentYear());
        model.setStudentContactNo(student.getStudentContactNo());
        model.setStudentEmail(student.getStudentEmail());
        return model;
    }

}
