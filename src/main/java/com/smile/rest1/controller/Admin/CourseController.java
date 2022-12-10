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

import com.smile.rest1.dao.CoursesRepo;
import com.smile.rest1.model.Course;

@RestController
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    private CoursesRepo courseRepository;

    // course mappings
    @GetMapping("")
    public List<Course> course() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course courseById(int id) {
        return courseRepository.findById(id).get();
    }

    @PostMapping("")
    public Course addcourse(@RequestBody Course course) {
        System.out.println(course);
        return courseRepository.save(course);
        // return course;
    }

    @PutMapping("")
    public Course updatecourse(@RequestBody Course course) {
        System.out.println(course);
        return courseRepository.save(course);
        // return course;
    }

    @DeleteMapping("/{id}")
    public String deletecourse(@RequestParam Integer id) {
        courseRepository.deleteById(id);
        return "course deleted with id: " + id;
    }
}
