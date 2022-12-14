package com.smile.rest1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String email;
	String password;
	String firstName;
	String lastName;
	String gender;
	String phone;
	String course;
	String dob;
	@Version
	int version;
	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "student_courses")
	// private Set<Course> courses = new HashSet<>();
	// private String batch;

}
