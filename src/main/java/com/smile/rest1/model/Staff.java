package com.smile.rest1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String email;
    String phone;
    @Version
    int version;
    @ManyToOne
    private Department department;
    private String designation;

    // @Override
    // public String toString() {
    // return "Staff [id=" + id + ", name=" + name + ", email=" + email + ", phone="
    // + phone + "department=" + department + ", designation=" + designation + "]";
    // }
}
