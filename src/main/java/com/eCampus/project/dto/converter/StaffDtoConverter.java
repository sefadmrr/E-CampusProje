package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.StaffDto;
import com.eCampus.project.model.Staff;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffDtoConverter {

    private final FacultyDtoConverter facultyDtoConverter;

    public StaffDtoConverter(FacultyDtoConverter facultyDtoConverter) {
        this.facultyDtoConverter = facultyDtoConverter;
    }

    public StaffDto convertStaffToStaffDto(Staff from) {
        return new StaffDto(
                from.getName(),
                from.getSurname(),
                from.getMail(),
                from.getNumber(),
                facultyDtoConverter.convertFacultyToFacultyDto(from.getFaculty()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public List<StaffDto> convertStaffListToStaffDtoList(List<Staff> from) {
        return from.stream().map(this::convertStaffToStaffDto).collect(Collectors.toList());
    }
}
