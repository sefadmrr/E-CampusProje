package com.eCampus.project.dto.request;

import lombok.Data;

@Data
public class UpdateStudentRequest {

    private String name;
    private String lastName;
    private String birthDay;
    private int termInfo;
    private String departmentName;
    private String studentAffairsUsername;
}
