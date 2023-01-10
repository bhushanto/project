package com.example.hostel.service;

import com.example.hostel.entity.Student;
import com.example.hostel.factory.StudentModelFactory;
import com.example.hostel.model.StudentForm;
import com.example.hostel.model.StudentModel;
import com.example.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentModel> list = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        if (!CollectionUtils.isEmpty(studentList)) {
            for (Student s : studentList) {
                list.add(StudentModelFactory.toStudentModel(s));
            }
        }
        return list;
    }

    @Override
    public StudentModel getStudent(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(StudentModelFactory::toStudentModel).orElse(null);
    }

    @Override
    public void createNewStudent(StudentForm studentForm) throws ParseException {
        Student student = new Student();
        student.setStudentName(studentForm.getStudentName());
        student.setStudentEmail(studentForm.getStudentEmail());
        student.setStudentContactNo(studentForm.getStudentContactNo());
        student.setStudentYear(studentForm.getStudentYear());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        student.ifPresent(value -> studentRepository.delete(value));
    }

    @Override
    public void updateStudent(StudentForm studentForm) throws ParseException {
        Student student = studentRepository.getById(studentForm.getStudentId());
        student.setStudentName(studentForm.getStudentName());
        student.setStudentYear(studentForm.getStudentYear());
        student.setStudentEmail(studentForm.getStudentEmail());
        student.setStudentContactNo(studentForm.getStudentContactNo());
        studentRepository.save(student);
    }
}
