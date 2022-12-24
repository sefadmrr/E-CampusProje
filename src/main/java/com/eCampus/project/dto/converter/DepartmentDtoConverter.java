package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.DepartmentDto;
import com.eCampus.project.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentDtoConverter {

    public DepartmentDto convertDepartmentToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getDepartmentName(),
                department.getCreateDate(),
                department.getUpdateDate()
        );
    }

    public List<DepartmentDto> convertDepartmentListToDepartmentDtoList(List<Department> departments){
        return departments.stream().map(this::convertDepartmentToDepartmentDto).collect(Collectors.toList());
    }
}
