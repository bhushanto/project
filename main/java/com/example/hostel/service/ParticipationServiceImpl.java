package com.example.hostel.service;

import com.example.hostel.entity.Participation;
import com.example.hostel.model.EventModel;
import com.example.hostel.model.ParticipationForm;
import com.example.hostel.model.ParticipationModel;
import com.example.hostel.model.StudentModel;
import com.example.hostel.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParticipationServiceImpl implements ParticipationService {

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    EventService eventService;

    @Override
    public List<EventModel> getEvents(Integer studentId) {
        List<EventModel> participatedEvents = new ArrayList<>();
        List<Participation> participationByStudent = participationRepository.findParticipationsByStudent_StudentId(studentId);
        if (!CollectionUtils.isEmpty(participationByStudent)) {
            for(Participation p: participationByStudent){
                EventModel e = eventService.getEvent(p.getEventId());
                participatedEvents.add(e);
            }
        }
        return participatedEvents;
    }

    @Override
    public List<StudentModel> getStudents(Integer eventId) {
        List<StudentModel> participatedStudents = new ArrayList<>();
        List<Participation> participationByEvent = participationRepository.findParticipationsByEvent_EventId(eventId);
        if (!CollectionUtils.isEmpty(participationByEvent)) {
            for(Participation p: participationByEvent){
                StudentModel s = studentService.getStudent(p.getStudentId());
                participatedStudents.add(s);
            }
        }
        return participatedStudents;
    }

    @Override
    public boolean participate(ParticipationForm participationForm)  throws ParseException {
        Participation p = new Participation();
        boolean isExist = this.exists(participationForm.getEventId(),participationForm.getStudentId());
        if(!isExist){
            p.setEventId(participationForm.getEventId());
            p.setStudentId(participationForm.getStudentId());
            participationRepository.save(p);
            return true;
        }
        return false;
    }

    public void withdraw(ParticipationForm participationForm)  throws ParseException {
        Integer eventId = participationForm.getEventId();
        Integer studentId = participationForm.getStudentId();
        Optional<Participation> p = participationRepository.findParticipationByEvent_EventIdAndStudent_StudentId(eventId,studentId);
        p.ifPresent(value -> participationRepository.delete(value));
    }


//    @Override
//    public void withdraw(Integer participationId) {
//        Optional<Participation> p = participationRepository.findById(participationId);
//        p.ifPresent(value -> participationRepository.delete(value));
//    }

    @Override
    public boolean exists(Integer eventId, Integer studentId) {
        //Get the participated students list from event id
        boolean isExist = false;
        List<StudentModel> participatedStudents = this.getStudents(eventId);
        for (StudentModel s : participatedStudents){
            if(s.getStudentId().equals(studentId)) isExist = true;
        }
        return isExist;
    }
}
