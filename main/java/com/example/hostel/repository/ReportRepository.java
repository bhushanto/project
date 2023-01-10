package com.example.hostel.repository;

import com.example.hostel.entity.Report;
import com.example.hostel.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findReportByStudent_StudentId(Integer studentId);
}
