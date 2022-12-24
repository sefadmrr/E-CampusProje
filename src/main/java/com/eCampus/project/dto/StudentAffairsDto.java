package com.eCampus.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentAffairsDto {

    private String username;
    private String mail;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
