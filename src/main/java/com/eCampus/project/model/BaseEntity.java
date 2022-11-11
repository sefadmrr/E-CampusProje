package com.eCampus.project.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
