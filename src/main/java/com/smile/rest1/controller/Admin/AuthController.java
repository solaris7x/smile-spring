package com.smile.rest1.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.rest1.dao.StudentRepo;
import com.smile.rest1.model.Student;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private StudentRepo studentRepository;

    @PostMapping("login")
    public String login(@RequestBody String username) {
        return "Login";
    }

    @PostMapping("register")
    public Student register(@RequestBody Student student) {
        // TODO: check if email already exists
        System.out.println(student);
        // Add to student table
        return studentRepository.save(student);
        // return "Register";
    }

}
