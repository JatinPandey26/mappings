package com.jatinpandey.mappings.Controller;

import com.jatinpandey.mappings.DTOS.MentorDTO;
import com.jatinpandey.mappings.Service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @PostMapping("/create")
    ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO){
        MentorDTO savedMentorDto = this.mentorService.createMentor(mentorDTO);
        return new ResponseEntity<>(savedMentorDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<MentorDTO>> getAllMentors(){
        return  new ResponseEntity<>(this.mentorService.getAllMentors(), HttpStatus.OK);
    }
}
