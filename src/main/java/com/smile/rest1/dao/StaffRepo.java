package com.smile.rest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.rest1.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {
    // public List<Staff> findAll();
}
