package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.FacultyDto;
import com.eCampus.project.model.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyDtoConverter {

    private final DepartmentDtoConverter departmentDtoConverter;

    public FacultyDtoConverter(DepartmentDtoConverter departmentDtoConverter) {
        this.departmentDtoConverter = departmentDtoConverter;
    }

    public FacultyDto convertFacultyToFacultyDto(Faculty faculty){
        return new FacultyDto(
                faculty.getFacultyName(),
                faculty.getCreateDate().toString(),
                departmentDtoConverter.convertDepartmentListToDepartmentDtoList(faculty.getDepartments())
        );
    }
}
