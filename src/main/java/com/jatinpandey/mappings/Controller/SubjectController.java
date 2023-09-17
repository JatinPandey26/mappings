package com.jatinpandey.mappings.Controller;

import com.jatinpandey.mappings.DTOS.SubjectDTO;
import com.jatinpandey.mappings.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/create")
    ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO , @RequestParam Long student_id , @RequestParam Long mentor_id){

        return new ResponseEntity<>(this.subjectService.createSubject(subjectDTO,mentor_id,student_id), HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    ResponseEntity<List<SubjectDTO>> getAll(){
        return new ResponseEntity<>(this.subjectService.getAll(),HttpStatus.OK);
    }

}
