package com.eCampus.project.dto.request;

import lombok.Data;

@Data
public class CreateLessonsRequest {
    private String lessonName;
    private String departmentName;
}
