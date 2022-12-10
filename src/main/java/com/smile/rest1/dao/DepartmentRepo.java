package com.smile.rest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.rest1.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    // public List<Department> findAll();

}
