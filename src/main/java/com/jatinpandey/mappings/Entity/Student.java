package com.jatinpandey.mappings.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String name;

    @JsonBackReference
    @ManyToOne
    Mentor mentor;

    @OneToMany(mappedBy = "student")
    List<Subject> subjects = new ArrayList<>();

}
