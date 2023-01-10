package com.example.hostel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Table(name = "report")
public class Report {

    public static final String REPORT_ID = "REPORT_ID";
    public static final String REPORT_TITLE = "REPORT_TITLE";
    public static final String REPORT_DESC = "REPORT_DESC";
    public static final String REPORT_STATUS = "REPORT_STATUS";
    public static final String REPORT_CATEGORY = "REPORT_CATEGORY";
    public static final String STUDENT_ID = "STUDENT_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = REPORT_ID)
    private Integer reportId;

    @Column(name = REPORT_TITLE)
    private String reportTitle;

    @Column(name = REPORT_STATUS)
    private String reportStatus;

    @Column(name = REPORT_DESC)
    private String reportDesc;

    @Column(name = REPORT_CATEGORY)
    private String reportCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="STUDENT_ID")
    private Student student;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc;
    }

    public String getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(String reportCategory) {
        this.reportCategory = reportCategory;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
