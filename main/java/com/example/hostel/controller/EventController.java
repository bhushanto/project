package com.example.hostel.controller;

import com.example.hostel.entity.Participation;
import com.example.hostel.entity.Student;
import com.example.hostel.model.EventForm;
import com.example.hostel.model.EventModel;
import com.example.hostel.model.StudentModel;
import com.example.hostel.service.EventService;
import com.example.hostel.service.ParticipationService;
import com.example.hostel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    StudentService studentService;

    @Autowired
    private ParticipationService participationService;

    @GetMapping("/event")
    public String navigateToEventPage(Model model) {
        List<EventModel> eventList = eventService.getAllEvents();
        model.addAttribute("eventList", eventList);
        model.addAttribute("activePage", "event");
        return "event";
    }

    @GetMapping("/event/new")
    public String navigateToNewEventFormPage(Model model) {
        model.addAttribute("eventForm", new EventForm());
        model.addAttribute("event", null);
        model.addAttribute("activePage", "event");
        return "event-form";
    }

    @GetMapping("/event/update/{eventId}")
    public String navigateToUpdateEventFormPage(@PathVariable Integer eventId, Model model) {
        EventModel event = eventService.getEvent(eventId);
        model.addAttribute("eventForm", new EventForm());
        model.addAttribute("event", event);
        model.addAttribute("activePage", "event");
        return "event-form";
    }

    @GetMapping("event/{eventId}")
    public String navigateToViewEventDetailsPage(@PathVariable Integer eventId, Model model) {
        EventModel event = eventService.getEvent(eventId);
        List<StudentModel> participatedStudents = participationService.getStudents(eventId);
        model.addAttribute("event", event);
        model.addAttribute("participatedStudent",participatedStudents);
        model.addAttribute("activePage", "event");
        return "event-detail";
    }


    @PostMapping("/create-event")
    public String createNewEvent(@Valid @ModelAttribute EventForm eventForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("eventForm", eventForm);
            return "event-form";
        }
        eventService.createNewEvent(eventForm);
        model.addAttribute("activePage", "event");
        return "redirect:/event";
    }

    @PostMapping("/update-event")
    public String updateEvent(@Valid @ModelAttribute EventForm eventForm, BindingResult bindingResult, Model model) throws ParseException {
        boolean formHasError = bindingResult.hasErrors();
        if (formHasError) {
            model.addAttribute("eventForm", eventForm);
            return "event-form";
        }
        eventService.updateEvent(eventForm);
        model.addAttribute("activePage", "event");
        return "redirect:/event/" + eventForm.getEventId().toString();
    }

    @GetMapping("/delete-event/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId, Model model) {
        eventService.deleteEvent(eventId);
        model.addAttribute("activePage", "event");
        return "redirect:/event";
    }

}