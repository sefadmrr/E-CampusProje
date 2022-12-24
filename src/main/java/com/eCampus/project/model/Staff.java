package com.eCampus.project.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Staff extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String number;
    @ManyToOne
    private Faculty faculty;

    public Staff(String name, String surname, String mail,
                 String number, Faculty faculty) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.number = number;
        this.faculty = faculty;
    }
}
