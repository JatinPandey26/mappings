package com.jatinpandey.mappings.Service;

import com.jatinpandey.mappings.DTOS.MentorDTO;
import com.jatinpandey.mappings.DTOS.StudentDTO;
import com.jatinpandey.mappings.Entity.Mentor;
import com.jatinpandey.mappings.Entity.Student;
import com.jatinpandey.mappings.Exceptions.ResourceNotFoundException;
import com.jatinpandey.mappings.Mappers.MentorMapper;
import com.jatinpandey.mappings.Mappers.StudentMapper;
import com.jatinpandey.mappings.Repository.MentorRepo;
import com.jatinpandey.mappings.Repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    MentorRepo mentorRepo;

    public StudentDTO createUser(StudentDTO studentDTO,Long mentor_id){
        Student student = this.studentMapper.toStudentFromStudentDTO(studentDTO);
        System.out.println(student.getId());
        Mentor mentor = this.mentorRepo.findById(mentor_id).orElseThrow(() -> new ResourceNotFoundException("Mentor","id",mentor_id));
        student.setMentor(mentor);
        Student savedStudent = this.studentRepo.save(student);
        return this.studentMapper.toStudentDTOFromStudent(savedStudent);
    }

    public List<StudentDTO> getAll(){
        return this.studentMapper.toStudentDTOListFromStudentList(this.studentRepo.findAll());
    }

}
