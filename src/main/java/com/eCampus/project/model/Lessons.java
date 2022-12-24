package com.eCampus.project.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Lessons extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    @ManyToOne
    private Department department;

    public Lessons(String lessonName, Department department) {
        this.lessonName = lessonName;
        this.department = department;
    }
}
