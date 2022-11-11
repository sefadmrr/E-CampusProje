package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String lastName;
    private String birthDay;
    private String registryDate;
    private int termInfo;
    private DepartmentDto department;
}
