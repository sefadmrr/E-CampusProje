package com.eCampus.project.controller;

import com.eCampus.project.dto.StudentDto;
import com.eCampus.project.dto.request.StudentCreateRequest;
import com.eCampus.project.dto.request.UpdateStudentRequest;
import com.eCampus.project.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody @Valid StudentCreateRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "lastname") String lastname) {

        studentService.delete(name, lastname);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<StudentDto> getByName(@RequestParam String name) {
        return ResponseEntity
                .ok(studentService.getByName(name));
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestParam String name, @RequestBody Optional<UpdateStudentRequest> request) {
        return ResponseEntity
                .ok(studentService.update(name, request));
    }

}
