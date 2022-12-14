package com.smile.rest1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String admin() {
        return "Hello from admin 🍬🍬";
    }

    // // Staff mappings
    // @GetMapping("/staff")
    // public List<Staff> Staff() {
    // return StaffRepository.findAll();
    // }
}
