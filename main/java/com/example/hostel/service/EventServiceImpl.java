package com.example.hostel.service;

import com.example.hostel.entity.Event;
import com.example.hostel.factory.EventModelFactory;
import com.example.hostel.model.EventForm;
import com.example.hostel.model.EventModel;
import com.example.hostel.repository.EventRepository;
import com.example.hostel.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    @Override
    public List<EventModel> getAllEvents() {
        List<EventModel> list = new ArrayList<>();
        List<Event> eventList = eventRepository.findAll();
        if (!CollectionUtils.isEmpty(eventList)) {
            for (Event e : eventList) {
                list.add(EventModelFactory.toEventModel(e));
            }
        }
        return list;
    }

    @Override
    public EventModel getEvent(Integer eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.map(EventModelFactory::toEventModel).orElse(null);
    }

    @Override
    public void createNewEvent(EventForm eventForm) throws ParseException {
        Event event = new Event();
        event.setEventName(eventForm.getEventName());
        event.setEventDescription(eventForm.getEventDescription());
        event.setEventDestination(eventForm.getEventDestination());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date eventStartDatetime = formatter.parse(eventForm.getEventStartDatetime());
        event.setEventStartDatetime(eventStartDatetime);
        if (!StringUtils.isEmpty(eventForm.getEventEndDatetime())) {
            Date eventEndDatetime = formatter.parse(eventForm.getEventEndDatetime());
            event.setEventEndDatetime(eventEndDatetime);
        }
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        event.ifPresent(value -> eventRepository.delete(value));
    }

    @Override
    public void updateEvent(EventForm eventForm) throws ParseException {
        Event event = eventRepository.getById(eventForm.getEventId());
        event.setEventName(eventForm.getEventName());
        event.setEventDescription(eventForm.getEventDescription());
        event.setEventDestination(eventForm.getEventDestination());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date eventStartDatetime = formatter.parse(eventForm.getEventStartDatetime());
        event.setEventStartDatetime(eventStartDatetime);
        if (!StringUtils.isEmpty(eventForm.getEventEndDatetime())) {
            Date eventEndDatetime = formatter.parse(eventForm.getEventEndDatetime());
            event.setEventEndDatetime(eventEndDatetime);
        }
        eventRepository.save(event);
    }
}
