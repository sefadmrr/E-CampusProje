package com.eCampus.project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;

    @ManyToOne
    private Faculty faculty;


    public Department(String departmentName, Faculty faculty) {
        this.departmentName = departmentName;
        this.faculty = faculty;
    }
}
