package com.eCampus.project.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String birthDay;
    @NotBlank
    private String registryDate;
    @NotNull
    private int termInfo;
}
