package com.example.hostel.entity;

import javax.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {
    //Participated record
    public static final String ID = "ID";
    public static final String EVENT_ID = "EVENT_ID";
    public static final String STUDENT_ID = "STUDENT_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Integer id;

    @Column(name = EVENT_ID)
    private Integer eventId;

    @Column(name = STUDENT_ID)
    private Integer studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="STUDENT_ID",insertable = false,updatable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="EVENT_ID",insertable = false,updatable = false)
    private Event event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
