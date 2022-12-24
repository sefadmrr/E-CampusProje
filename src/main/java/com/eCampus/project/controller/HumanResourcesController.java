package com.eCampus.project.controller;

import com.eCampus.project.dto.HumanResourcesDto;
import com.eCampus.project.dto.request.CreateHumanResourcesRequest;
import com.eCampus.project.service.HumanResourcesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/human-resource")
public class HumanResourcesController {

    private final HumanResourcesService humanResourcesService;

    public HumanResourcesController(HumanResourcesService
                                            humanResourcesService) {
        this.humanResourcesService = humanResourcesService;
    }

    @PostMapping
    public ResponseEntity<HumanResourcesDto> save(@RequestBody @Valid CreateHumanResourcesRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(humanResourcesService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String username) {
        humanResourcesService.delete(username);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<HumanResourcesDto> getByUsername(@RequestParam String username) {
        return ResponseEntity
                .ok(humanResourcesService.getByUsername(username));
    }
}
