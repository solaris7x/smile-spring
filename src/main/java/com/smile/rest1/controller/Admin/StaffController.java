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

import com.smile.rest1.dao.StaffRepo;
import com.smile.rest1.model.Staff;

@RestController
@RequestMapping("/admin/staff")
public class StaffController {

    @Autowired
    private StaffRepo staffRepository;

    // Staff mappings
    @GetMapping("")
    public List<Staff> staff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Staff staffById(int id) {
        return staffRepository.findById(id).get();
    }

    @PostMapping("")
    public Staff addStaff(@RequestBody Staff staff) {
        System.out.println(staff);
        return staffRepository.save(staff);
        // return staff;
    }

    @PutMapping("")
    public Staff updateStaff(@RequestBody Staff staff) {
        System.out.println(staff);
        return staffRepository.save(staff);
        // return staff;
    }

    @DeleteMapping("/{id}")
    public String deleteStaff(@RequestParam Integer id) {
        staffRepository.deleteById(id);
        return "Staff deleted with id: " + id;
    }
}
