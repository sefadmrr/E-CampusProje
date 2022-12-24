package com.eCampus.project.controller;

import com.eCampus.project.dto.LessonsDto;
import com.eCampus.project.service.LessonsListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons-list")
public class LessonsListController {

    private final LessonsListService lessonsListService;

    public LessonsListController(LessonsListService lessonsListService) {
        this.lessonsListService = lessonsListService;
    }

    @GetMapping("/get-by-department-name")
    public ResponseEntity<List<LessonsDto>> getByDepartmentName(@RequestParam String departmentName) {
        return ResponseEntity
                .ok(lessonsListService.getLessonsByDepartmentName(departmentName));
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<LessonsDto> getByName(@RequestParam String lessonsName) {
        return ResponseEntity
                .ok(lessonsListService.getByName(lessonsName));
    }
}
