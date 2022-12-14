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

import com.smile.rest1.dao.TimetableRepo;
import com.smile.rest1.model.Timetable;

@CrossOrigin
@RestController
@RequestMapping("/admin/timetable")
public class TimetableController {

    @Autowired
    private TimetableRepo timetableRepository;

    // Timetable mappings
    @GetMapping("")
    public List<Timetable> timetable() {
        return timetableRepository.findAll();
    }

    @GetMapping("/{id}")
    public Timetable timetableById(@PathVariable Integer id) {
        return timetableRepository.findById(id).get();
    }

    @PostMapping("")
    public Timetable addTimetable(@RequestBody Timetable timetable) {
        System.out.println(timetable);
        return timetableRepository.save(timetable);
        // return timetable;
    }

    @PutMapping("")
    public Timetable updateTimetable(@RequestBody Timetable timetable) {
        System.out.println(timetable);
        return timetableRepository.save(timetable);
        // return timetable;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteTimetable(@PathVariable Integer id) {
        timetableRepository.deleteById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "Timetable deleted with id: " + id);
        return res;
    }

    // Find by course name
    @GetMapping("/find/{name}")
    public List<Timetable> findCourseByName(@PathVariable String name) {
        return timetableRepository.findByCourse(name);
    }
}
