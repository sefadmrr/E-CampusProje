package com.eCampus.project.repository;

import com.eCampus.project.model.StudentAffairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAffairsRepository extends JpaRepository<StudentAffairs,Long> {
    Optional<StudentAffairs> findStudentAffairsByUsername(String username);
    boolean existsStudentAffairsByUsername(String username);
}
