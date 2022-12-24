package com.eCampus.project.service;

import com.eCampus.project.dto.DepartmentDto;
import com.eCampus.project.dto.converter.DepartmentDtoConverter;
import com.eCampus.project.dto.request.CreateDepartmentRequest;
import com.eCampus.project.exception.generic.NoAuthException;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Admin;
import com.eCampus.project.model.Department;
import com.eCampus.project.model.Faculty;
import com.eCampus.project.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoConverter departmentDtoConverter;
    private final FacultyService facultyService;
    private final AdminService adminService;

    public DepartmentService(DepartmentRepository departmentRepository,
                             DepartmentDtoConverter departmentDtoConverter,
                             FacultyService facultyService,
                             AdminService adminService) {
        this.departmentRepository = departmentRepository;
        this.departmentDtoConverter = departmentDtoConverter;
        this.facultyService = facultyService;
        this.adminService = adminService;
    }

    public DepartmentDto save(CreateDepartmentRequest request) {
        Faculty faculty = facultyService.getFacultyByFacultyName(request.getFacultyName());
        Admin admin = adminService.getAdminByUsername(request.getAdminUsername());

        Department saved = new Department(
                request.getDepartmentName(),
                faculty
        );

        if (Objects.isNull(admin)) {
            throw new NoAuthException("no auth!");
        }

        return departmentDtoConverter.convertDepartmentToDepartmentDto(
                departmentRepository.save(saved));
    }

    public void delete(String departmentName) {
        departmentRepository.deleteById(getDepartmentByName(departmentName).getId());
    }

    public DepartmentDto getByName(String departmentName) {
        return departmentDtoConverter.convertDepartmentToDepartmentDto(
                getDepartmentByName(departmentName));
    }

    protected Department getDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName)
                .orElseThrow(() -> new NotFoundException("department not found, departmentName: " + departmentName));
    }
}
