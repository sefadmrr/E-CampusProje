package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.LessonsDto;
import com.eCampus.project.model.Lessons;
import org.springframework.stereotype.Component;

@Component
public class LessonsDtoConverter {

    private final DepartmentDtoConverter departmentDtoConverter;

    public LessonsDtoConverter(DepartmentDtoConverter departmentDtoConverter) {
        this.departmentDtoConverter = departmentDtoConverter;
    }

    public LessonsDto convertLessonsToLessonsDto(Lessons lessons){
        return new LessonsDto(
                lessons.getLessonName(),
                departmentDtoConverter.convertDepartmentToDepartmentDto(lessons.getDepartment())
        );
    }
}
