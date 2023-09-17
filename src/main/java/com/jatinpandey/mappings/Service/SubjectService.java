package com.jatinpandey.mappings.Service;

import com.jatinpandey.mappings.DTOS.StudentDTO;
import com.jatinpandey.mappings.DTOS.SubjectDTO;
import com.jatinpandey.mappings.Entity.Mentor;
import com.jatinpandey.mappings.Entity.Student;
import com.jatinpandey.mappings.Entity.Subject;
import com.jatinpandey.mappings.Exceptions.ResourceNotFoundException;
import com.jatinpandey.mappings.Mappers.SubjectMapper;
import com.jatinpandey.mappings.Repository.MentorRepo;
import com.jatinpandey.mappings.Repository.StudentRepo;
import com.jatinpandey.mappings.Repository.SubjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    MentorRepo mentorRepo;

    @Autowired
    SubjectMapper subjectMapper;


    public SubjectDTO createSubject(SubjectDTO subjectDTO,Long mentor_id , Long student_id){

        Student student = this.studentRepo.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("Student","id",student_id));
        Mentor mentor = this.mentorRepo.findById(mentor_id).orElseThrow(() -> new ResourceNotFoundException("Mentor","id",mentor_id));

        Subject subject = this.subjectMapper.toSubjectFromSubjectDTO(subjectDTO);
        subject.setMentor(mentor);
        subject.setStudent(student);
        Subject savedSubject = this.subjectRepo.save(subject);
        return this.subjectMapper.toSubjectDTOFromSubject(savedSubject);
    }

    public List<SubjectDTO> getAll(){
        List<Subject> subjects = this.subjectRepo.findAll();
        System.out.println(subjects);
        return this.subjectMapper.toSubjectDTOListFromSubjectList(subjects);
    }

}
