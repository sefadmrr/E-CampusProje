package com.eCampus.project.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateStudentAffairsRequest {

    @NotBlank
    private String username;
    @Email
    private String mail;
    @NotBlank
    private String password;
    @NotBlank
    private String adminUsername;
}
