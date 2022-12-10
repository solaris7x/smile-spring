package com.smile.rest1.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smile.rest1.dao.DepartmentRepo;
import com.smile.rest1.model.Department;

@RestController
@RequestMapping("/admin/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepository;

    // Department mappings
    @GetMapping("")
    public List<Department> department() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department departmentById(int id) {
        return departmentRepository.findById(id).get();
    }

    @PostMapping("")
    public Department addDepartment(@RequestBody Department department) {
        System.out.println(department);
        return departmentRepository.save(department);
        // return department;
    }

    @PutMapping("")
    public Department updateDepartment(@RequestBody Department department) {
        System.out.println(department);
        return departmentRepository.save(department);
        // return department;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@RequestParam Integer id) {
        departmentRepository.deleteById(id);
        return "Department deleted with id: " + id;
    }
}
