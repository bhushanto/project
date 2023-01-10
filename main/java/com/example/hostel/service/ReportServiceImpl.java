package com.example.hostel.service;

import com.example.hostel.entity.Report;
import com.example.hostel.factory.ReportModelFactory;
import com.example.hostel.model.ReportForm;
import com.example.hostel.model.ReportModel;
import com.example.hostel.repository.ReportRepository;
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

public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportModel> getAllReports() {
        List<ReportModel> list = new ArrayList<>();
        List<Report> reportList = reportRepository.findAll();
        if (!CollectionUtils.isEmpty(reportList)) {
            for (Report s : reportList) {
                list.add(ReportModelFactory.toReportModel(s));
            }
        }
        return list;
    }

    @Override
    public ReportModel getReport(Integer reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        return report.map(ReportModelFactory::toReportModel).orElse(null);
    }

    @Override
    public void createNewReport(ReportForm reportForm) throws ParseException {
        Report report = new Report();
        report.setReportTitle(reportForm.getReportTitle());
        report.setReportDesc(reportForm.getReportDesc());
        report.setReportStatus(reportForm.getReportStatus());
        report.setStudent(reportForm.getStudent());
        report.setReportCategory(reportForm.getReportCategory());
        reportRepository.save(report);
    }

    @Override
    public void deleteReport(Integer reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        report.ifPresent(value -> reportRepository.delete(value));
    }

    @Override
    public void updateReport(ReportForm reportForm) throws ParseException {
        Report report = reportRepository.getById(reportForm.getReportId());
        report.setReportTitle(reportForm.getReportTitle());
        report.setReportDesc(reportForm.getReportDesc());
        report.setReportStatus(reportForm.getReportStatus());
        report.setStudent(reportForm.getStudent());
        report.setReportCategory(reportForm.getReportCategory());
        reportRepository.save(report);
    }

    @Override
    public List<ReportModel> getAllReportsFromStudent(Integer studentId) {
        List<ReportModel> list = new ArrayList<>();
        List<Report> reportList = reportRepository.findReportByStudent_StudentId(studentId);
        if (!CollectionUtils.isEmpty(reportList)) {
            for (Report s : reportList) {
                list.add(ReportModelFactory.toReportModel(s));
            }
        }
        return list;
    }
}
