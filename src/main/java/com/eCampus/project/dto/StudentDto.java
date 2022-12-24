package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String lastName;
    private String birthDay;
    private int termInfo;
    private DepartmentDto department;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
