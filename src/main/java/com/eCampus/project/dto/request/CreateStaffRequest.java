package com.eCampus.project.dto.request;

import lombok.Data;

@Data
public class CreateStaffRequest {
    private String name;
    private String surname;
    private String mail;
    private String number;
    private String facultyName;
}
