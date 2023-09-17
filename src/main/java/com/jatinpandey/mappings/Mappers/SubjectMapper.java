package com.jatinpandey.mappings.Mappers;

import com.jatinpandey.mappings.DTOS.SubjectDTO;
import com.jatinpandey.mappings.Entity.Subject;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",uses = {StudentMapper.class, MentorMapper.class})
public interface SubjectMapper {

    SubjectDTO toSubjectDTOFromSubject(Subject subject);

    Subject toSubjectFromSubjectDTO(SubjectDTO subjectDTO);

    List<SubjectDTO> toSubjectDTOListFromSubjectList(List<Subject> subjectList);

    List<Subject> toSubjectListFromSubjectDTOList(List<SubjectDTO> subjectDTOList);

}
