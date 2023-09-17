package com.jatinpandey.mappings.Mappers;

import com.jatinpandey.mappings.DTOS.MentorDTO;
import com.jatinpandey.mappings.Entity.Mentor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {StudentMapper.class, SubjectMapper.class})
public interface MentorMapper {

    Mentor toMentorFromMentorDTO(MentorDTO mentorDTO);

    MentorDTO toMentorDTOFromMentor(Mentor mentor);

    List<MentorDTO> toMentorDTOListFromMentorList(List<Mentor> mentorList);

}
