package com.eCampus.project.service;

import com.eCampus.project.dto.LessonsDto;
import com.eCampus.project.dto.converter.LessonsDtoConverter;
import com.eCampus.project.model.Department;
import com.eCampus.project.repository.LessonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonsListService {

    private final LessonsRepository lessonsRepository;
    private final LessonsDtoConverter lessonsDtoConverter;
    private final DepartmentService departmentService;

    public LessonsListService(LessonsRepository lessonsRepository,
                              LessonsDtoConverter lessonsDtoConverter,
                              DepartmentService departmentService) {
        this.lessonsRepository = lessonsRepository;
        this.lessonsDtoConverter = lessonsDtoConverter;
        this.departmentService = departmentService;
    }

    public List<LessonsDto> getLessonsByDepartmentName(String departmentName) {
        Department department = departmentService.getDepartmentByName(departmentName);

        return lessonsDtoConverter.convertLessonsToLessonsDtoList(
                lessonsRepository.findAll()
                .stream()
                .filter(lessons -> lessons.getDepartment().equals(department))
                .collect(Collectors.toList())
        );
    }

    public LessonsDto getByName(String lessonsName) {
        return lessonsDtoConverter.convertLessonsToLessonsDto(
                lessonsRepository.findLessonsByLessonName(lessonsName)
                        .orElseThrow(() -> new RuntimeException(""))
        );
    }
}
