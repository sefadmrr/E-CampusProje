package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.StudentDto;
import com.eCampus.project.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {

    private final DepartmentDtoConverter departmentDtoConverter;

    public StudentDtoConverter(DepartmentDtoConverter departmentDtoConverter) {
        this.departmentDtoConverter = departmentDtoConverter;
    }

    public StudentDto convertStudentToStudentDto(Student student){
        return new StudentDto(
                student.getName(),
                student.getLastName(),
                student.getBirthDay(),
                student.getTermInfo(),
                departmentDtoConverter.convertDepartmentToDepartmentDto(student.getDepartment()),
                student.getCreateDate(),
                student.getUpdateDate()
        );
    }
}
