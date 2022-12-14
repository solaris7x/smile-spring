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

import com.smile.rest1.dao.StaffRepo;
import com.smile.rest1.model.Staff;

@CrossOrigin
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
    public Staff staffById(@PathVariable Integer id) {
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
    public Map<String, String> deleteStaff(@PathVariable Integer id) {
        staffRepository.deleteById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "Staff deleted with id: " + id);
        return res;
    }
}
