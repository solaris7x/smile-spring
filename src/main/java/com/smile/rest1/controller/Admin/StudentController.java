package com.smile.rest1.controller.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smile.rest1.dao.StudentRepo;
import com.smile.rest1.model.Student;

@CrossOrigin
@RestController
@RequestMapping("/admin/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepository;

    // Student mappings
    @GetMapping("")
    public List<Student> student() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student studentById(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
        // return student;
    }

    @PutMapping("")
    public Student updateStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
        // return student;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "Student deleted with id: " + id);
        return res;
    }
}
