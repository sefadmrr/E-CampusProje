package com.eCampus.project.dto.request;

import lombok.Data;

@Data
public class CreateDepartmentRequest {
    private String departmentName;
    private String facultyName;
    private String adminUsername;
}
