package com.example.hostel.controller;

import com.example.hostel.model.ReportForm;
import com.example.hostel.model.ReportModel;
import com.example.hostel.model.StudentModel;
import com.example.hostel.repository.StudentRepository;
import com.example.hostel.service.ReportService;
import com.example.hostel.service.StudentService;
import com.example.hostel.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/report")
    public String navigateToReportPage(Model model) {
        List<ReportModel> reportList = reportService.getAllReports();
        model.addAttribute("reportList", reportList);
        model.addAttribute("activePage", "report");
        return "report";
    }

    @GetMapping("/report/new")
    public String navigateToNewReportFormPage(Model model) {
        List<StudentModel> studentList = studentService.getAllStudents();
        model.addAttribute("reportForm", new ReportForm());
        model.addAttribute("report", null);
        model.addAttribute("allStudents", studentList);
        model.addAttribute("activePage", "report");
        return "report-form";
    }

    @GetMapping("/report/update/{reportId}")
    public String navigateToUpdateReportFormPage(@PathVariable Integer reportId, Model model) {
        List<StudentModel> studentList = studentService.getAllStudents();
        ReportModel report = reportService.getReport(reportId);
        model.addAttribute("reportForm", new ReportForm());
        model.addAttribute("activePage", "report");
        model.addAttribute("allStudents", studentList);
        model.addAttribute("report", report);
        return "report-form";
    }

    @GetMapping("report/{reportId}")
    public String navigateToViewReportDetailsPage(@PathVariable Integer reportId, Model model) {
        ReportModel report = reportService.getReport(reportId);
        model.addAttribute("activePage", "report");
        model.addAttribute("report", report);
        return "report-detail";
    }

    @PostMapping("/create-report")
    public String createNewReport(@Valid @ModelAttribute ReportForm reportForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("reportForm", reportForm);
            return "report-form";
        }
        reportService.createNewReport(reportForm);
        model.addAttribute("activePage", "report");
        return "redirect:/report";
    }

    @PostMapping("/update-report")
    public String updateReport(@Valid @ModelAttribute ReportForm reportForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("reportForm", reportForm);
            return "report-form";
        }
        reportService.updateReport(reportForm);
        model.addAttribute("activePage", "report");
        return "redirect:/report/" + reportForm.getReportId().toString();
    }

    @GetMapping("/delete-report/{reportId}")
    public String deleteReport(@PathVariable Integer reportId, Model model) {
        reportService.deleteReport(reportId);
        model.addAttribute("activePage", "report");
        return "redirect:/report";
    }

}
