package com.eCampus.project.service;

import com.eCampus.project.dto.StudentAffairsDto;
import com.eCampus.project.dto.request.CreateStudentAffairsRequest;
import com.eCampus.project.exception.generic.ExistException;
import com.eCampus.project.exception.generic.NoAuthException;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Admin;
import com.eCampus.project.model.StudentAffairs;
import com.eCampus.project.repository.StudentAffairsRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentAffairsService {

    private final StudentAffairsRepository studentAffairsRepository;
    private final AdminService adminService;

    public StudentAffairsService(StudentAffairsRepository studentAffairsRepository,
                                 AdminService adminService) {
        this.studentAffairsRepository = studentAffairsRepository;
        this.adminService = adminService;
    }

    public StudentAffairsDto save(CreateStudentAffairsRequest request) {
        Admin admin = adminService.getAdminByUsername(request.getAdminUsername());

        StudentAffairs saved = new StudentAffairs(
                request.getUsername(),
                request.getMail(),
                request.getPassword()
        );

        if (studentAffairsRepository.existsStudentAffairsByUsername(saved.getUsername())) {
            throw new ExistException("student affairs exist, username: " + saved.getUsername());
        }

        if (Objects.isNull(admin)) {
            throw new NoAuthException("no auth!");
        }

        studentAffairsRepository.save(saved);
        return new StudentAffairsDto(
                saved.getUsername(),
                saved.getMail(),
                saved.getCreateDate(),
                saved.getCreateDate()
        );
    }

    public void delete(String username) {
        StudentAffairs fromDbStudentAffairs = getStudentAffairsByName(username);

        studentAffairsRepository.deleteById(fromDbStudentAffairs.getId());
    }

    public StudentAffairsDto getByUsername(String username) {
        StudentAffairs fromDbStudentAffairs = getStudentAffairsByName(username);

        return new StudentAffairsDto(
                fromDbStudentAffairs.getUsername(),
                fromDbStudentAffairs.getMail(),
                fromDbStudentAffairs.getCreateDate(),
                fromDbStudentAffairs.getUpdateDate()
        );
    }

    protected StudentAffairs getStudentAffairsByName(String username) {
        return studentAffairsRepository.findStudentAffairsByUsername(username)
                .orElseThrow(() -> new NotFoundException("student affairs not found, username: " + username));
    }

}
