package com.eCampus.project.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateFacultyRequest {

    @NotBlank
    private String facultyName;
    @NotBlank
    private String adminUsername;
}
