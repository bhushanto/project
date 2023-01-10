package com.example.hostel.repository;

import com.example.hostel.entity.Event;
import com.example.hostel.entity.Participation;
import com.example.hostel.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {

    List<Participation> findParticipationsByEvent_EventId(Integer eventId);

    List<Participation> findParticipationsByStudent_StudentId(Integer studentId);

    Optional<Participation> findById(Integer participationId);
    
    Optional<Participation> findParticipationByEvent_EventIdAndStudent_StudentId(Integer eventId, Integer studentId);
}
