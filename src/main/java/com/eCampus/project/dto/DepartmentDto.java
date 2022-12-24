package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DepartmentDto {
    private String departmentName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
