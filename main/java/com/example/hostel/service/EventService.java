package com.example.hostel.service;

import com.example.hostel.model.EventForm;
import com.example.hostel.model.EventModel;

import java.text.ParseException;
import java.util.List;

public interface EventService {
    List<EventModel> getAllEvents();
    EventModel getEvent(Integer eventId);
    void createNewEvent(EventForm event) throws ParseException;
    void deleteEvent(Integer eventId);
    void updateEvent(EventForm eventForm) throws ParseException;
}
