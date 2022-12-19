package com.smile.rest1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.rest1.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    // public List<Student> findAll();
    public List<Student> findByEmail(String email);

}
