package com.eCampus.project.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String birthDay;
    private int termInfo;
    @ManyToOne
    private Department department;

    public Student(String name, String lastName, String birthDay,
                   int termInfo, Department department) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.termInfo = termInfo;
        this.department = department;
    }
}
