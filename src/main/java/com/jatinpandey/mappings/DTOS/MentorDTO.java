package com.jatinpandey.mappings.DTOS;

import com.jatinpandey.mappings.Entity.Student;
import com.jatinpandey.mappings.Entity.Subject;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MentorDTO {
    private Long id;
    String name;
    List<Student> students = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();

}
