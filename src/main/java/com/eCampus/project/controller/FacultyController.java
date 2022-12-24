package com.eCampus.project.controller;

import com.eCampus.project.dto.FacultyDto;
import com.eCampus.project.dto.request.CreateFacultyRequest;
import com.eCampus.project.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<FacultyDto> save(@Valid @RequestBody CreateFacultyRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(facultyService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String facultyName) {
        facultyService.delete(facultyName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FacultyDto>> getAll() {
        return ResponseEntity
                .ok(facultyService.getAll());
    }
}
