package com.example.hostel.service;

import com.example.hostel.model.EventModel;
import com.example.hostel.model.ParticipationForm;
import com.example.hostel.model.StudentModel;

import java.text.ParseException;
import java.util.List;

public interface ParticipationService {
    List<EventModel> getEvents(Integer studentId);
    List<StudentModel> getStudents(Integer eventId);
    boolean participate(ParticipationForm participationForm) throws ParseException;
    void withdraw(ParticipationForm participationForm) throws ParseException;
    boolean exists(Integer eventId, Integer studentId);
}
