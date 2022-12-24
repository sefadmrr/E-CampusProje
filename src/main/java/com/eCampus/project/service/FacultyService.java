package com.eCampus.project.service;

import com.eCampus.project.dto.FacultyDto;
import com.eCampus.project.dto.converter.FacultyDtoConverter;
import com.eCampus.project.dto.request.CreateFacultyRequest;
import com.eCampus.project.exception.generic.ExistException;
import com.eCampus.project.exception.generic.NoAuthException;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Admin;
import com.eCampus.project.model.Faculty;
import com.eCampus.project.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyDtoConverter facultyDtoConverter;
    private final AdminService adminService;

    public FacultyService(FacultyRepository facultyRepository,
                          FacultyDtoConverter facultyDtoConverter,
                          AdminService adminService) {
        this.facultyRepository = facultyRepository;
        this.facultyDtoConverter = facultyDtoConverter;
        this.adminService = adminService;
    }

    public FacultyDto save(CreateFacultyRequest request) {
        Admin admin = adminService.getAdminByUsername(request.getAdminUsername());

        Faculty saved = new Faculty(
                request.getFacultyName()
        );

        if (facultyRepository.existsFacultyByFacultyName(saved.getFacultyName())) {
            throw new ExistException("faculty exist, faculty name: " + saved.getFacultyName());
        }

        if (Objects.isNull(admin)) {
            throw new NoAuthException("no auth!");
        }

        return facultyDtoConverter.convertFacultyToFacultyDto(facultyRepository.save(saved));
    }

    public List<FacultyDto> getAll() {
        return facultyRepository.findAll()
                .stream()
                .map(facultyDtoConverter::convertFacultyToFacultyDto)
                .collect(Collectors.toList());
    }

    public void delete(String facultyName) {
        Faculty faculty = getFacultyByFacultyName(facultyName);
        facultyRepository.deleteById(faculty.getId());
    }

    protected Faculty getFacultyByFacultyName(String facultyName) {
        return facultyRepository.findFacultyByFacultyName(facultyName)
                .orElseThrow(() -> new NotFoundException("faculty not found, faculty name: " + facultyName));
    }


}
