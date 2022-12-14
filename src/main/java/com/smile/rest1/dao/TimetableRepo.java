package com.smile.rest1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.rest1.model.Timetable;

public interface TimetableRepo extends JpaRepository<Timetable, Integer> {
    List<Timetable> findByCourse(String course);

}
