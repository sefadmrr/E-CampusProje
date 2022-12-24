package com.eCampus.project.service;

import com.eCampus.project.dto.StudentDto;
import com.eCampus.project.dto.converter.StudentDtoConverter;
import com.eCampus.project.dto.request.StudentCreateRequest;
import com.eCampus.project.dto.request.UpdateStudentRequest;
import com.eCampus.project.exception.generic.NoAuthException;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Department;
import com.eCampus.project.model.Student;
import com.eCampus.project.model.StudentAffairs;
import com.eCampus.project.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;
    private final DepartmentService departmentService;
    private final StudentAffairsService studentAffairsService;

    public StudentService(StudentRepository studentRepository,
                          StudentDtoConverter studentDtoConverter,
                          DepartmentService departmentService,
                          StudentAffairsService studentAffairsService) {
        this.studentRepository = studentRepository;
        this.studentDtoConverter = studentDtoConverter;
        this.departmentService = departmentService;
        this.studentAffairsService = studentAffairsService;
    }

    public StudentDto save(StudentCreateRequest request) {
        Department department = departmentService.getDepartmentByName(request.getDepartmentName());
        StudentAffairs studentAffairs = studentAffairsService.getStudentAffairsByName(request.getStudentAffairsUsername());

        Student saved = new Student(
                request.getName(),
                request.getLastName(),
                request.getBirthDay(),
                request.getTermInfo(),
                department
        );

        if (Objects.isNull(studentAffairs)) {
            throw new NoAuthException("StudentAffairs not found");

        }

        return studentDtoConverter.convertStudentToStudentDto(
                studentRepository.save(saved));
    }

    public void delete(String name, String lastname) {
        Student getByName = studentRepository.findStudentByName(name)
                .orElseThrow(() -> new RuntimeException(""));
        Student getByLastname = studentRepository.findStudentByLastName(lastname)
                .orElseThrow(() -> new RuntimeException(""));

        if (getByName.equals(getByLastname)) {
            studentRepository.delete(getByLastname);
        }
    }

    public StudentDto update(String name, Optional<UpdateStudentRequest> request) {
        Student fromDbStudent = getStudentByName(name);
        Department department = departmentService.getDepartmentByName(request.get().getDepartmentName());
        StudentAffairs studentAffairs = studentAffairsService.getStudentAffairsByName(request.get().getStudentAffairsUsername());

        Student updated = new Student(
                fromDbStudent.getId(),
                request.get().getName(),
                request.get().getLastName(),
                request.get().getBirthDay(),
                request.get().getTermInfo(),
                department
        );

        if (Objects.isNull(studentAffairs)) {
            throw new NoAuthException("no auth!");
        }

        return studentDtoConverter.convertStudentToStudentDto(studentRepository.save(updated));
    }

    public StudentDto getByName(String name) {
        return studentDtoConverter.convertStudentToStudentDto(
                studentRepository.findStudentByName(name)
                        .orElseThrow(() -> new NotFoundException("student not found, name: " + name)));
    }

    protected Student getStudentByName(String name) {
        return studentRepository.findStudentByName(name)
                .orElseThrow(() -> new NotFoundException("student not found, name: " + name));
    }

}
