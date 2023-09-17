package com.jatinpandey.mappings.DTOS;

import com.jatinpandey.mappings.Entity.Mentor;
import com.jatinpandey.mappings.Entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class SubjectDTO {

    private Long id;

    private String name;

    private Mentor mentor;

    private Student student;

}
