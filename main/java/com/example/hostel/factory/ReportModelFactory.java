package com.example.hostel.factory;

import com.example.hostel.entity.Report;
import com.example.hostel.model.ReportModel;

public class ReportModelFactory {

    public static ReportModel toReportModel(Report report) {
        ReportModel model = new ReportModel();
        model.setReportId(report.getReportId());
        model.setReportTitle(report.getReportTitle());
        model.setReportDesc(report.getReportDesc());
        model.setReportStatus(report.getReportStatus());
        model.setReportCategory(report.getReportCategory());
        model.setStudent(report.getStudent());
        return model;
    }

}
