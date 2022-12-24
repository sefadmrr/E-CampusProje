package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LessonsDto {
    private String lessonName;
    private DepartmentDto department;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
