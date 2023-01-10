package com.example.hostel.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {

    public static final String STUDENT_ID = "STUDENT_ID";
    public static final String STUDENT_NAME = "STUDENT_NAME";
    public static final String STUDENT_YEAR = "STUDENT_YEAR";
    public static final String STUDENT_CONTACT_NO = "STUDENT_CONTACT_NO";
    public static final String STUDENT_EMAIL = "STUDENT_EMAIL";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = STUDENT_ID)
    private Integer studentId;

    @Column(name = STUDENT_NAME)
    private String studentName;

    @Column(name = STUDENT_YEAR)
    private String studentYear;

    @Column(name = STUDENT_CONTACT_NO)
    private String studentContactNo;

    @Column(name = STUDENT_EMAIL)
    private String studentEmail;

    /*
     * To get the report submitted by Student
     *
     * */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Report> reportList = new ArrayList<>();

    /**
     * Student's participation record
     */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participation> participations = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "events_students", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"), inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"))
//    private Collection<Event> events;

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

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }


//    public Collection<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(Collection<Event> events) {
//        this.events = events;
//    }
}