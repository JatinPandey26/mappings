package com.jatinpandey.mappings.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;


    @OneToMany(mappedBy = "mentor")
    List<Student> students = new ArrayList<>();


    @OneToMany(mappedBy = "mentor")
    List<Subject> subjects = new ArrayList<>();
}
