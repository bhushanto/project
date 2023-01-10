package com.example.hostel.factory;

import com.example.hostel.entity.Event;
import com.example.hostel.model.EventModel;
import org.thymeleaf.util.StringUtils;

public class EventModelFactory {

    public static EventModel toEventModel(Event event) {
        EventModel model = new EventModel();
        model.setEventId(event.getEventId());
        model.setEventName(event.getEventName());
        if (!StringUtils.isEmpty(event.getEventDescription())) {
            model.setEventDescription(event.getEventDescription().replaceAll("(\r\n|\n)", "<br />"));
        }
        model.setEventDestination(event.getEventDestination());
        model.setEventStartDatetime(event.getEventStartDatetime());
        if (event.getEventEndDatetime() != null) {
            model.setEventEndDatetime(event.getEventEndDatetime());
        }
        return model;
    }

}
