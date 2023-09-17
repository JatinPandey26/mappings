package com.jatinpandey.mappings.DTOS;

import com.jatinpandey.mappings.Entity.Mentor;
import com.jatinpandey.mappings.Entity.Student;
import com.jatinpandey.mappings.Entity.Subject;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    String name;

    Mentor mentor;

    List<Subject> subjects = new ArrayList<>();

}
