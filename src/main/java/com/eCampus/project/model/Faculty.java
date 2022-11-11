package com.eCampus.project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facultyName;
    private LocalDateTime createDate = LocalDateTime.now();
    @OneToMany
    private List<Department> departments;


}
