package com.eCampus.project.controller;

import com.eCampus.project.dto.LessonsDto;
import com.eCampus.project.dto.request.CreateLessonsRequest;
import com.eCampus.project.service.LessonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonsController {

    private final LessonsService lessonsService;

    public LessonsController(LessonsService lessonsService) {
        this.lessonsService = lessonsService;
    }

    @PostMapping
    public ResponseEntity<LessonsDto> save(@RequestBody @Valid CreateLessonsRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lessonsService.save(request));
    }

    public ResponseEntity<?> delete(@RequestParam String lessonsName) {
        lessonsService.delete(lessonsName);

        return ResponseEntity.noContent().build();
    }
}
