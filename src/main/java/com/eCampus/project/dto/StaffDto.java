package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StaffDto {
    private String name;
    private String surname;
    private String mail;
    private String number;
    private FacultyDto facultyDto;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
