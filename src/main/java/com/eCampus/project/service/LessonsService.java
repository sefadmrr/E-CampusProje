package com.eCampus.project.service;

import com.eCampus.project.dto.LessonsDto;
import com.eCampus.project.dto.converter.LessonsDtoConverter;
import com.eCampus.project.dto.request.CreateLessonsRequest;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Department;
import com.eCampus.project.model.Lessons;
import com.eCampus.project.repository.LessonsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LessonsService {

    private final LessonsRepository lessonsRepository;
    private final LessonsDtoConverter lessonsDtoConverter;
    private final DepartmentService departmentService;

    public LessonsService(LessonsRepository lessonsRepository,
                          LessonsDtoConverter lessonsDtoConverter,
                          DepartmentService departmentService) {
        this.lessonsRepository = lessonsRepository;
        this.lessonsDtoConverter = lessonsDtoConverter;
        this.departmentService = departmentService;
    }

    public LessonsDto save(CreateLessonsRequest request) {
        Department department = departmentService.getDepartmentByName(request.getDepartmentName());
        Lessons saved = new Lessons(
                request.getLessonName(),
                department
        );

        return lessonsDtoConverter.convertLessonsToLessonsDto(lessonsRepository.save(saved));
    }

    public void delete(String lessonsName) {
        lessonsRepository.deleteById(getLessonsByName(lessonsName).getId());
    }

    public Lessons getLessonsByName(String lessonsName) {
        return lessonsRepository.findLessonsByLessonName(lessonsName)
                .orElseThrow(() -> new NotFoundException("lessons not found, lessonsName: " + lessonsName));
    }
}
