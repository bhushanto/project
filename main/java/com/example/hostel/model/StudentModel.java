package com.example.hostel.model;

import com.example.hostel.entity.Report;
import org.hibernate.annotations.CascadeType;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentModel {
    private Integer studentId;
    private String studentName;
    private String studentYear;
    private String studentContactNo;
    private String studentEmail;

    @OneToMany(mappedBy="student")
    private List<Report> reportList;

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

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }
}
