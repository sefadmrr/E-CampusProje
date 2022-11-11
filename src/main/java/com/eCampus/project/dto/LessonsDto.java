package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonsDto {
    private String lessonName;
    private DepartmentDto department;
}
