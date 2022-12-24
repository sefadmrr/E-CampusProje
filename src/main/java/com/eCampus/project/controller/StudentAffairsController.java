package com.eCampus.project.controller;

import com.eCampus.project.dto.StudentAffairsDto;
import com.eCampus.project.dto.request.CreateStudentAffairsRequest;
import com.eCampus.project.service.StudentAffairsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student-affairs")
public class StudentAffairsController {

    private final StudentAffairsService studentAffairsService;

    public StudentAffairsController(StudentAffairsService studentAffairsService) {
        this.studentAffairsService = studentAffairsService;
    }

    @PostMapping
    public ResponseEntity<StudentAffairsDto> save(@Valid @RequestBody CreateStudentAffairsRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentAffairsService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String username) {
        studentAffairsService.delete(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<StudentAffairsDto> getByUsername(@RequestParam String username) {
        return ResponseEntity
                .ok(studentAffairsService.getByUsername(username));
    }
}
