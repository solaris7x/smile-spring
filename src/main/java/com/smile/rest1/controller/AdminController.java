package com.smile.rest1.controller;

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

import com.smile.rest1.dao.StudentRepo;
import com.smile.rest1.model.Student;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentRepo studentRepository;

    @GetMapping("")
    public String admin() {
        return "Hello from admin 🍬🍬";
    }

    // Student mappings
    @GetMapping("/students")
    public List<Student> student() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student studentById(int id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
        // return student;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
        // return student;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@RequestParam Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted with id: " + id;
    }

    // // Staff mappings
    // @GetMapping("/staff")
    // public List<Staff> Staff() {
    // return StaffRepository.findAll();
    // }
}
