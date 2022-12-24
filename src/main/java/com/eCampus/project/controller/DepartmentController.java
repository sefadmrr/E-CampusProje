package com.eCampus.project.controller;

import com.eCampus.project.dto.DepartmentDto;
import com.eCampus.project.dto.request.CreateDepartmentRequest;
import com.eCampus.project.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody @Valid CreateDepartmentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(departmentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String departmentName) {
        departmentService.delete(departmentName);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<DepartmentDto> getByName(@RequestParam String departmentName) {
        return ResponseEntity
                .ok(departmentService.getByName(departmentName));
    }
}
