package com.example.hostel.controller;

import com.example.hostel.model.EventModel;
import com.example.hostel.model.ReportModel;
import com.example.hostel.model.StudentForm;
import com.example.hostel.model.StudentModel;
import com.example.hostel.service.ParticipationService;
import com.example.hostel.service.ReportService;
import com.example.hostel.service.StudentService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ParticipationService participationService;

    @GetMapping("/student")
    public String navigateToStudentPage(Model model) {
        List<StudentModel> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        model.addAttribute("activePage", "student");
        return "student";
    }

    @GetMapping("/student/new")
    public String navigateToNewStudentFormPage(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("student", null);
        model.addAttribute("activePage", "student");
        return "student-form";
    }

    @GetMapping("/student/update/{studentId}")
    public String navigateToUpdateStudentFormPage(@PathVariable Integer studentId, Model model) {
        StudentModel student = studentService.getStudent(studentId);
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("activePage", "student");
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("student/{studentId}")
    public String navigateToViewStudentDetailsPage(@PathVariable Integer studentId, Model model) {
        StudentModel student = studentService.getStudent(studentId);
        List<ReportModel> reportsList = reportService.getAllReportsFromStudent(studentId);
        List<EventModel> participatedEventList = participationService.getEvents(studentId);
        model.addAttribute("activePage", "student");
        model.addAttribute("student", student);
        model.addAttribute("reportsList", reportsList);
        model.addAttribute("participatedEventList", participatedEventList);
        return "student-detail";
    }

    @PostMapping("/create-student")
    public String createNewStudent(@Valid @ModelAttribute StudentForm studentForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("studentForm", studentForm);
            return "student-form";
        }
        studentService.createNewStudent(studentForm);
        model.addAttribute("activePage", "student");
        return "redirect:/student";
    }

    @PostMapping("/update-student")
    public String updateStudent(@Valid @ModelAttribute StudentForm studentForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("studentForm", studentForm);
            return "student-form";
        }
        studentService.updateStudent(studentForm);
        model.addAttribute("activePage", "student");
        return "redirect:/student/" + studentForm.getStudentId().toString();
    }

    @GetMapping("/delete-student/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudent(studentId);
        model.addAttribute("activePage", "student");
        return "redirect:/student";
    }

}
