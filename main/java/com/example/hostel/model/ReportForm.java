package com.example.hostel.model;

import com.example.hostel.entity.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReportForm {

    private Integer reportId;

    @NotEmpty(message = "Please input report title.")
    @Size(min = 1, max = 200, message = "Please input between between {min} and {max} characters.")
    private String reportTitle;

    @NotEmpty(message = "Please input report description.")
    @Size(min = 1, message = "Please input at least {min} characters.")
    private String reportDesc;

    @NotEmpty(message = "Please input report status.")
    private String reportStatus;

    @NotEmpty(message = "Please input report category.")
    private String reportCategory;

    @NotNull(message = "Please mention the student who submitted this report")
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

    public String getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
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
