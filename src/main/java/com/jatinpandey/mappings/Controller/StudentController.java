package com.jatinpandey.mappings.Controller;

import com.jatinpandey.mappings.DTOS.StudentDTO;
import com.jatinpandey.mappings.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO, @RequestParam Long mentor_id){
        StudentDTO savedStudent = this.studentService.createUser(studentDTO,mentor_id);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<StudentDTO>> getAllStudents(){
        return  new ResponseEntity<>(this.studentService.getAll(),HttpStatus.OK);
    }
}
