package com.example.hostel.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "event")
public class Event {

    public static final String EVENT_ID = "EVENT_ID";
    public static final String EVENT_NAME = "EVENT_NAME";
    public static final String EVENT_DESCRIPTION = "EVENT_DESCRIPTION";
    public static final String EVENT_START_DATETIME = "EVENT_START_DATETIME";
    public static final String EVENT_END_DATETIME = "EVENT_END_DATETIME";
    public static final String EVENT_DESTINATION = "EVENT_DESTINATION";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EVENT_ID)
    private Integer eventId;

    @Column(name = EVENT_NAME)
    private String eventName;

    @Column(name = EVENT_DESCRIPTION)
    private String eventDescription;

    @Column(name = EVENT_START_DATETIME)
    private Date eventStartDatetime;

    @Column(name = EVENT_END_DATETIME)
    private Date eventEndDatetime;

    @Column(name = EVENT_DESTINATION)
    private String eventDestination;


    /**
     * Event's participated students
     */
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participation> participations = new ArrayList<>();



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

    public String getEventDestination() {
        return eventDestination;
    }

    public void setEventDestination(String eventDestination) {
        this.eventDestination = eventDestination;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

}
