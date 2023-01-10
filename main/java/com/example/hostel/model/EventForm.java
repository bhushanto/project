package com.example.hostel.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EventForm {
    private Integer eventId;

    @NotEmpty(message = "Please input event name.")
    @Size(min = 1, max = 200, message = "Please input between between {min} and {max} characters.")
    private String eventName;

    @NotEmpty(message = "Please input event description.")
    @Size(min = 1, max = 2000, message = "Please input between between {min} and {max} characters.")
    private String eventDescription;

    @NotEmpty(message = "Please input event destination.")
    private String eventDestination;

    @NotEmpty(message = "Please select event start datetime.")
    private String eventStartDatetime;
    private String eventEndDatetime;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDatetime() {
        return eventStartDatetime;
    }

    public void setEventStartDatetime(String eventStartDatetime) {
        this.eventStartDatetime = eventStartDatetime;
    }

    public String getEventEndDatetime() {
        return eventEndDatetime;
    }

    public void setEventEndDatetime(String eventEndDatetime) {
        this.eventEndDatetime = eventEndDatetime;
    }

    public String getEventDestination() {
        return eventDestination;
    }

    public void setEventDestination(String eventDestination) {
        this.eventDestination = eventDestination;
    }

}
