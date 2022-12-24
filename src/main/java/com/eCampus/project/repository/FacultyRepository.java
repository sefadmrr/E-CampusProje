package com.eCampus.project.repository;

import com.eCampus.project.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    boolean existsFacultyByFacultyName(String facultyName);
    Optional<Faculty> findFacultyByFacultyName(String facultyName);
}
