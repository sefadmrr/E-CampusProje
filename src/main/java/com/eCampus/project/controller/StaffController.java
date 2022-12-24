package com.eCampus.project.controller;

import com.eCampus.project.dto.StaffDto;
import com.eCampus.project.dto.request.CreateStaffRequest;
import com.eCampus.project.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public ResponseEntity<StaffDto> save(@RequestBody @Valid CreateStaffRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(staffService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String mail) {
        staffService.delete(mail);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<StaffDto> getByMail(@RequestParam String mail) {
        return ResponseEntity
                .ok(staffService.getByMail(mail));
    }
}
