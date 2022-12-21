package com.smile.rest1.controller.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    // ENV variables
    @Value("${env.adminPassword}")
    private String adminPassword;

    @Value("${env.staffPassword}")
    private String staffPassword;

    @PostMapping("login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        System.out.println(user);
        // If admin
        if (user.get("role").equals("Admin") && user.get("password").equals(adminPassword)) {
            HashMap<String, String> res = new HashMap<String, String>();
            res.put("message", "Admin logged in");
            res.put("role", "Admin");
            res.put("name", "Admin");
            return res;
        }
        // If staff
        else if (user.get("role").equals("Staff") && user.get("password").equals(staffPassword)) {
            HashMap<String, String> res = new HashMap<String, String>();
            res.put("message", "Staff logged in");
            res.put("role", "Staff");
            res.put("name", "Staff");
            return res;
        }
        // If student
        else if (user.get("role").equals("Student")) {
            List<Student> students = studentRepository.findByEmail(user.get("email"));
            Student student = students.get(0);
            System.out.println(student);
            if (student != null && student.getPassword().equals(user.get("password"))) {
                // return student.toMap();
                HashMap<String, String> res = new HashMap<String, String>();
                res.put("message", "Student logged in");
                res.put("role", "Student");
                res.put("name", student.getFirstName());
                return res;
            }
        }
        // Invalid creds
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "Invalid credentials");
        return res;

    };

    @PostMapping("register")
    public Student register(@RequestBody Student student) {
        // TODO: check if email already exists
        System.out.println(student);
        // Add to student table
        return studentRepository.save(student);
        // return "Register";
    }

}
