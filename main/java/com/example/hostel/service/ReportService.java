package com.example.hostel.service;

import com.example.hostel.model.ReportForm;
import com.example.hostel.model.ReportModel;

import java.text.ParseException;
import java.util.List;

public interface ReportService {
    List<ReportModel> getAllReports();
    ReportModel getReport(Integer reportId);
    void createNewReport(ReportForm report) throws ParseException;
    void deleteReport(Integer reportId);
    void updateReport(ReportForm reportForm) throws ParseException;
    List<ReportModel> getAllReportsFromStudent(Integer studentId);
}
