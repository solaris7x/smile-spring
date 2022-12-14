package com.smile.rest1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "Hello from smile spring 🍬🍬";
    }
}
