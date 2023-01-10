package com.example.hostel.model;

import com.example.hostel.entity.Student;

import java.util.Collection;
import java.util.Date;

public class EventModel {
    private Integer eventId;
    private String eventName;
    private String eventDescription;
    private String eventDestination;
    private Date eventStartDatetime;
    private Date eventEndDatetime;
    private Collection<Student> students;

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

    public String getEventDestination() {
        return eventDestination;
    }

    public void setEventDestination(String eventDestination) {
        this.eventDestination = eventDestination;
    }

    public Date getEventStartDatetime() {
        return eventStartDatetime;
    }

    public void setEventStartDatetime(Date eventStartDatetime) {
        this.eventStartDatetime = eventStartDatetime;
    }

    public Date getEventEndDatetime() {
        return eventEndDatetime;
    }

    public void setEventEndDatetime(Date eventEndDatetime) {
        this.eventEndDatetime = eventEndDatetime;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

}
