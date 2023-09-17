package com.jatinpandey.mappings.Service;

import com.jatinpandey.mappings.DTOS.MentorDTO;
import com.jatinpandey.mappings.Entity.Mentor;
import com.jatinpandey.mappings.Exceptions.ResourceNotFoundException;
import com.jatinpandey.mappings.Mappers.MentorMapper;
import com.jatinpandey.mappings.Repository.MentorRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    @Autowired
    MentorRepo mentorRepo;

    @Autowired
    MentorMapper mentorMapper;

    public MentorDTO createMentor(MentorDTO mentorDTO){
        Mentor mentor = this.mentorMapper.toMentorFromMentorDTO(mentorDTO);
        Mentor savedMentor = this.mentorRepo.save(mentor);
        return this.mentorMapper.toMentorDTOFromMentor(savedMentor);
    }

    public MentorDTO getMentorById(Long mentor_id){
        Mentor mentor = this.mentorRepo.findById(mentor_id).orElseThrow(() -> new ResourceNotFoundException("Mentor","id",mentor_id));
        return this.mentorMapper.toMentorDTOFromMentor(mentor);
    }

    public List<MentorDTO> getAllMentors(){
        return this.mentorMapper.toMentorDTOListFromMentorList(this.mentorRepo.findAll());
    }
}
