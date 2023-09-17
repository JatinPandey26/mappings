package com.jatinpandey.mappings.Mappers;

import com.jatinpandey.mappings.DTOS.StudentDTO;
import com.jatinpandey.mappings.Entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MentorMapper.class, SubjectMapper.class})

public interface StudentMapper {
StudentDTO toStudentDTOFromStudent(Student student);

Student toStudentFromStudentDTO(StudentDTO studentDTO);

List<StudentDTO> toStudentDTOListFromStudentList(List<Student> studentList);
List<Student>  toStudentListFromStudentDTOList(List<StudentDTO> studentDTOList);
}
