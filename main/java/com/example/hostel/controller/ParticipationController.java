package com.example.hostel.controller;

import com.example.hostel.entity.Participation;
import com.example.hostel.model.EventModel;
import com.example.hostel.model.ParticipationForm;
import com.example.hostel.model.StudentModel;
import com.example.hostel.service.EventService;
import com.example.hostel.service.ParticipationService;
import com.example.hostel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @Autowired
    private EventService eventService;

    @Autowired
    StudentService studentService;

    @GetMapping("/event/add/{eventId}")
    public String navigateToAddStudentsPage(@PathVariable Integer eventId, Model model){
        EventModel event = eventService.getEvent(eventId);
        List<StudentModel> studentList = studentService.getAllStudents();
        List<StudentModel> participatedStudents = participationService.getStudents(eventId);
        model.addAttribute("participationForm",new ParticipationForm());
        model.addAttribute("event", event);
        model.addAttribute("studentList",studentList);
        model.addAttribute("participatedStudentsIds",participatedStudents.stream().map(StudentModel::getStudentId).collect(Collectors.toList()));
        model.addAttribute("activePage", "event");
        return "event-add-participants";
    }

    @PostMapping("/event/add-student")
    public String addStudent(@Valid @ModelAttribute ParticipationForm participationForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) throws ParseException {
        boolean isSuccess = participationService.participate(participationForm);
        List<StudentModel> participatedStudents = participationService.getStudents(participationForm.getEventId());
        if(isSuccess){
            redirectAttrs.addFlashAttribute("success", "Student added to Event!");
        }else{
            redirectAttrs.addFlashAttribute("fail", "Student already participated the Event!");
        }
        return "redirect:/event/add/"+participationForm.getEventId().toString();
    }

    @PostMapping("/event/remove-student")
    public String removeStudentFromEvent(@Valid @ModelAttribute ParticipationForm participationForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) throws ParseException {
        participationService.withdraw(participationForm);
        redirectAttrs.addFlashAttribute("success", "Student removed from the event!");
        return "redirect:/event/add/"+participationForm.getEventId().toString();
    }

    @PostMapping("/student/withdraw")
    public String removeEventFromStudent(@Valid @ModelAttribute ParticipationForm participationForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) throws ParseException {
        participationService.withdraw(participationForm);
        redirectAttrs.addFlashAttribute("success", "Student removed from the event!");
        return "redirect:/student/"+participationForm.getStudentId().toString();
    }

}
