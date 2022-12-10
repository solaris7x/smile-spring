package com.smile.rest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.rest1.model.Course;

public interface CoursesRepo extends JpaRepository<Course, Integer> {

}
